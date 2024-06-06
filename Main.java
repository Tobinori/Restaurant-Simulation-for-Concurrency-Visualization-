import ProcessingFood.Employee;
import ProcessingFood.KitchenPosition;
import ProcessingOrder.EmployeeManager;
import ProcessingOrder.Order;
import ProcessingOrder.OrderManager;

import java.util.List;

import FoodComponents.Food;
import FoodComponents.Ingredient;
import FoodComponents.Menu;
import FoodComponents.MenuList;
import FoodComponents.Tool;
import FoodComponents.Kitchen;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{Menu menu = new Menu();
        // Create a new order manager
        OrderManager orderManager = new OrderManager();
        // Create a new employee manager
        EmployeeManager employeeManager = new EmployeeManager(orderManager, new Kitchen());
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
