package FoodComponents;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Ingredient{
    private IngredientsList name;
    private AtomicInteger quantity;
    private AtomicBoolean isAvilable;

    public Ingredient(IngredientsList ingredient, AtomicInteger quantity) {
        this.name = ingredient;
        this.quantity = quantity;
        this.isAvilable = new AtomicBoolean(true);
    }

    public Ingredient(IngredientsList ingredient) {
        this.name = ingredient;
        this.quantity = ingredient.getStartQuantity();
        this.isAvilable = new AtomicBoolean(true);
    }

    public AtomicInteger getQuantity() {
        return quantity;
    }

    public boolean isKeyIngredient() {
        return name.isKeyIngredient();
    }

    public boolean isAvilable() {
        return isAvilable.get();
    }

    public void setQuantity(int quantity) {
        this.quantity = new AtomicInteger(quantity);
    }

    public IngredientsList getIngredient() {
        return name;
    }
    

    public void useIngredient() {
        if(quantity.get() == 1){
            quantity.getAndDecrement();
            isAvilable.set(false);
            System.out.println("The last " + name + " has been used and is now out of stock.");
        }
        else if (quantity.get() > 1) {
            quantity.getAndDecrement();
        }
        else {
            isAvilable.set(false);
            System.out.println("Ingredient " + name + " is out of stock");
        }
    }

    


    
}
