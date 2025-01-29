package org.example.ProcessingFood.ProcessingFood;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.example.FoodComponents.Food;
import org.example.FoodComponents.Kitchen;
import org.example.ProcessingOrder.OrderObserver;
import org.example.controller.ValueHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Employee implements Runnable{
    private Kitchen kitchen;
    private EmployeeList employee;
    private LinkedList<Food> foodQueue;
    private int orderMemorySize;
    private Lock mutex = new ReentrantLock();
    private Condition hasWorkToDo = mutex.newCondition();
    private Condition capacityIsNotExceeded = mutex.newCondition();
    private ExecutorService foodExecutor;
    private ValueHandler valueHandler;
    
    public Employee(EmployeeList employee, Kitchen kitchen, ValueHandler valueHandler) {
        this.employee = employee;
        this.kitchen = kitchen;
        orderMemorySize = employee.getMaxOrderMemory();
        foodQueue = new LinkedList<Food>();
        foodExecutor = Executors.newFixedThreadPool(orderMemorySize);
        this.valueHandler = valueHandler;
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
            updateMemory();
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
            updateMemory();
        }
    }

    public EmployeeList getEmployee() {
        return employee;
    }

    public String getMemory() {
        String memory = "";
        int order = 1;
        for (Food food : foodQueue) {
            memory = memory + " " + order + ". " + food.getName() + "\n";
            order++;
        }
        return memory;
    }

    private void updateMemory(){
            if (employee.getName().equals("Diego")){
                valueHandler.setMemoryDiego(this.getMemory());
            }
            if (employee.getName().equals("Evelyn")){
                valueHandler.setMemoryEvelyn(this.getMemory());
            }
            if (employee.getName().equals("Richi")){
                valueHandler.setMemoryRichi(this.getMemory());
            }
            if (employee.getName().equals("Yoga")){
                valueHandler.setMemoryYoga(this.getMemory());
            }
        }
    
}
