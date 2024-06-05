import ProcessingFood.Employee;
import ProcessingFood.KitchenPosition;
import ProcessingOrder.EmployeeManager;
import ProcessingOrder.Order;
import ProcessingOrder.OrderManager;

import java.util.List;

import FoodComponents.Food;
import FoodComponents.Ingredient;
import FoodComponents.Tool;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee diego = new Employee("Diego", KitchenPosition.COUNTER, 1.2, 28, 6);
        Employee evelyn = new Employee("Evelyn", KitchenPosition.GRILL, 1, 27, 7);
        Employee richi = new Employee("Richi", KitchenPosition.SALAD_STATION, 0.5, 30, 3);
        Employee yoga = new Employee("Yoga", KitchenPosition.SALAD_STATION, 2, 2, 6);
        OrderManager orderManager = new OrderManager();
        EmployeeManager employeeManager = new EmployeeManager(orderManager);
        employeeManager.addEmployee(diego);
        employeeManager.addEmployee(evelyn);
        employeeManager.addEmployee(richi);
        employeeManager.addEmployee(yoga);
        Ingredient saltyPieCold = new Ingredient("Salty Pie Cold", 18, true);
        Ingredient salad = new Ingredient("Salad", 20, false);
        Ingredient saladSauce = new Ingredient("Salad Sauce", 50, false);
        Tool knife = new Tool("Knife");
        Tool spatula = new Tool("Spatula");
        Tool microwave = new Tool("Microwave");
        Tool plate = new Tool("Plate");
        ArrayList<Ingredient> ingredients = new ArrayList<>(List.of(saltyPieCold, salad, saladSauce));
        ArrayList<Tool> tools = new ArrayList<>(List.of(knife, spatula, microwave, plate));
        Food saltyPie = new Food("Salty Pie", ingredients, tools,3, KitchenPosition.COUNTER);
        Order order = new Order();
        order.addFood(saltyPie);
        orderManager.addOrder(order);
        employeeManager.giveOrder();
        employeeManager.start();
        




    }
}
