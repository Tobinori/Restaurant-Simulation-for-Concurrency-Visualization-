package org.example.main;

import org.example.FoodComponents.Kitchen;
import org.example.FoodComponents.Menu;
import org.example.ProcessingOrder.EmployeeManager;
import org.example.ProcessingOrder.Order;
import org.example.ProcessingOrder.OrderManager;
import org.example.ui.KitchenWindow;
import org.example.controller.ValueHandler;

import javafx.application.Application;


public class Main {
    public static void main(String[] args) {
        Application.launch(KitchenWindow.class, args);
        try{Menu menu = new Menu();
        ValueHandler valueHandler = new ValueHandler();
        // Create a new order manager
        OrderManager orderManager = new OrderManager();
        // Create a new employee manager
        EmployeeManager employeeManager = new EmployeeManager(orderManager, new Kitchen(), valueHandler);
        // Create a new order
        Order order = new Order();
        // Add the food to the order
        order.addFood(menu.createFriedFish());
        order.addFood(menu.createFriedFish());
        order.addFood(menu.createFriedFish());
        order.addFood(menu.createHotDog());

        // Add the order to the order manager
        orderManager.addOrder(order);
        order = new Order();
        order.addFood(menu.createSaltyPie());
        orderManager.addOrder(order);
        // Start the employee manager
        employeeManager.start();
    }
    catch (Exception e) {
        System.out.println(e);
    }
    }
}
