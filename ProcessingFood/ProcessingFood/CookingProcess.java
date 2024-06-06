package ProcessingFood;

import FoodComponents.Food;
import FoodComponents.FoodOutOfStockException;
import FoodComponents.Kitchen;

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
            System.out.println("Employee " + employee.getEmployee().getName() + " has completed " + food.getName());
            
        }
        catch (FoodOutOfStockException e) {
            e.printStackTrace();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}


}
