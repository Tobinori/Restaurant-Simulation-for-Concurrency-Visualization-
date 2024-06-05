package ProcessingOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;

import FoodComponents.Food;

public class Order {

    ArrayList<Food> order;
    
    public Order() {
        order = new ArrayList<Food>();
    }

    public void addFood(Food food) {
        order.add(food);
    }

    public ArrayList<Food> getOrder() {
        return order;
    }
}
