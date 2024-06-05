package ProcessingFood;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import FoodComponents.Food;
public class Employee implements Runnable{
    private EmployeeList employee;
    private LinkedList<Food> foodQueue;
    private int orderMemorySize;
    private Lock mutex = new ReentrantLock();
    private Condition hasWorkToDo = mutex.newCondition();
    private Condition capacityIsNotExceeded = mutex.newCondition();
    
    public Employee(EmployeeList employee) {
        this.employee = employee;
        orderMemorySize = employee.getMaxOrderMemory();
        foodQueue = new LinkedList<Food>();
    }

    @Override
    public void run() {
        work();
    }

    private void work() {
        for (int i = 0; i < foodQueue.size(); i++) {
            if (foodQueue.get(i) != null) {
                System.out.println("Employee " + employee.getName()  + " is working on " + foodMemory[i].getName());
                try {
                    Thread.sleep((long) (foodQueue.get(i).getProcessingTime() * employee.getSpeed() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
