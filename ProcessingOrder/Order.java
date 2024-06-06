package ProcessingOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;

import FoodComponents.Food;

public class Order {

    private ArrayList<Food> order;
    private ArrayList<Food> completedFood;
    private int orderNumber;
    private boolean isCompleted;
    private long orderedTime;
    private long completedTime;
    private long timeToComplete;
    
    
    public Order() {
        order = new ArrayList<Food>();
        completedFood = new ArrayList<Food>();
        isCompleted = false;
        orderedTime = System.currentTimeMillis();
    }

    public void addFood(Food food) {
        order.add(food);
    }

    public void completeFood(Food food) {
        completedFood.add(food);
    }

    public void completeOrder() {
        if(order.equals(completedFood))
        {
            System.out.println("Order " + orderNumber + " is completed.");
            isCompleted = true;
        }
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
    }
}
