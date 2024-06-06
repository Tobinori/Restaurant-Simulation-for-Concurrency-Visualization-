package ProcessingFood;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import FoodComponents.Kitchen;

import FoodComponents.Food;
public class Employee implements Runnable{
    private Kitchen kitchen;
    private EmployeeList employee;
    private LinkedList<Food> foodQueue;
    private int orderMemorySize;
    private Lock mutex = new ReentrantLock();
    private Condition hasWorkToDo = mutex.newCondition();
    private Condition capacityIsNotExceeded = mutex.newCondition();
    private ExecutorService foodExecutor;
    
    public Employee(EmployeeList employee, Kitchen kitchen) {
        this.employee = employee;
        this.kitchen = kitchen;
        orderMemorySize = employee.getMaxOrderMemory();
        foodQueue = new LinkedList<Food>();
        foodExecutor = Executors.newFixedThreadPool(orderMemorySize);
    }

    @Override
    public void run() {
        work();
    }

    private void work() {
        while (true) {
            mutex.lock();
            try {
                while (foodQueue.isEmpty()) {
                    hasWorkToDo.await();
                }
                Food food = foodQueue.removeFirst();
                mutex.unlock();
                try {
                    System.out.println("Employee " + employee.getName() + " is preparing " + food.getName());
                    foodExecutor.execute(new CookingProcess(food, kitchen, this));
                } finally {
                    mutex.lock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.unlock();
            }
        }
    }

    public void addFoodToMemory(Food food) throws InterruptedException {
        mutex.lock();
        try {
            while (foodQueue.size() >= orderMemorySize) {
                capacityIsNotExceeded.await();
            }
            foodQueue.addLast(food);
            hasWorkToDo.signal();
        } finally {
            mutex.unlock();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < foodQueue.size(); i++) {
            if (foodQueue.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    public void removeFoodFromMemory(Food food) {
        
            mutex.lock();
            try {
            for (int i = 0; i < foodQueue.size(); i++) {
                if (foodQueue.get(i) == food) {
                    foodQueue.remove(i);
                    capacityIsNotExceeded.signal();
                    break;
                }
            }
        } finally {
            mutex.unlock();
        }
    }

    public EmployeeList getEmployee() {
        return employee;
    }
}
