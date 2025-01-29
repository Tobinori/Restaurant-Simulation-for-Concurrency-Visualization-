package org.example.ProcessingOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.example.FoodComponents.Food;
import org.example.FoodComponents.FoodObserver;

public class Order implements FoodObserver{

    private ArrayList<Food> order;
    private ArrayList<Food> completedFood;
    private int orderNumber;
    private boolean isCompleted;
    private long orderedTime;
    private long completedTime;
    private long timeToComplete;
    
    private List<OrderObserver> observers = new ArrayList<>(); // List of observers
    
    public Order() {
        order = new ArrayList<Food>();
        completedFood = new ArrayList<Food>();
        isCompleted = false;
        orderedTime = System.currentTimeMillis();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.onOrderCompleted(this);
        }
    }

    public void addFood(Food food) {
        food.addObserver(this);
        order.add(food);
    }

    @Override
    public void completeFood(Food food) {
        completedFood.add(food);
        if(completedFood.size() == order.size()) {
            completeOrder();
        }
    }

    public boolean completeOrder() {
        for(Food food : order) {
            if (!food.isCompleted()) {
                System.out.println("Order " + orderNumber + " is not completed.");
                return false;
            }
        }
        isCompleted = true;
        completedTime = System.currentTimeMillis();
        timeToComplete = completedTime - orderedTime;
        System.out.println("It took " + timeToComplete/1000 + " minutes to complete order " + orderNumber + ".");
        notifyObservers();
        return true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public ArrayList<Food> getOrder() {
        return order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
        for (Food food : order) {
            food.setOrderNumber(orderNumber);
        }
    }
}
