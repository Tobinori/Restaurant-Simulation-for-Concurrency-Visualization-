package org.example.ProcessingFood.ProcessingFood;

import org.example.FoodComponents.Food;
import org.example.FoodComponents.FoodOutOfStockException;
import org.example.FoodComponents.Kitchen;
import org.example.ProcessingOrder.Order;
import org.example.ProcessingOrder.OrderManager;

public class CookingProcess implements Runnable {
    private Food food;
    private Kitchen kitchen;
    private Employee employee;

    public CookingProcess(Food food, Kitchen kitchen, Employee employee) {
        this.food = food;
        this.kitchen = kitchen;
        this.employee = employee;
    }
    
    @Override
    public void run() {
        try {
            kitchen.cook(food);
            employee.removeFoodFromMemory(food);
            System.out.println("Employee " + employee.getEmployee().getName() + " has completed " + food.getName()); 
            food.setCompleted();  
        }
        catch (FoodOutOfStockException e) {
            e.printStackTrace();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}


}
