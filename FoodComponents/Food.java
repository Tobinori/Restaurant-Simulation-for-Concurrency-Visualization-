package FoodComponents;

import java.util.ArrayList;
import ProcessingFood.KitchenPosition;
public class Food{

    private MenuList dish;
    private ArrayList<IngredientsList> ingredientsNeeded;
    private ArrayList<ToolList> toolsNeeded;
    private boolean isCompleted;
    private boolean isAssigned;
    private boolean isInStock;


    public Food(MenuList dish, ArrayList<IngredientsList> ingredientsNeeded, ArrayList<ToolList> toolsNeeded) {
        this.dish = dish;
        this.ingredientsNeeded = ingredientsNeeded;
        this.toolsNeeded = toolsNeeded;
        isCompleted = false;
        isAssigned = false;
    }

    public String getName() {
        return dish.getName();
    }

    public int getProcessingTime() {
        return dish.getPreperationTime();
    }

    public ArrayList<IngredientsList> getIngredients() {
        return ingredientsNeeded;
    }

    public ArrayList<ToolList> getTools() {
        return toolsNeeded;
    }


    public void addTool(ToolList tool) {
        toolsNeeded.add(tool);
    }

    public KitchenPosition getPosition() {
        return dish.getKitchenPosition();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned() {
        isAssigned = true;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }


}