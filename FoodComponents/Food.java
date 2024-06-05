package FoodComponents;

import java.util.ArrayList;
import ProcessingFood.KitchenPosition;
public class Food{

    String name;
    ArrayList<Ingredient> ingredients;
    ArrayList<Tool> tools;
    int processingTime;
    KitchenPosition position;

    public Food(String name, ArrayList<Ingredient> ingredients, ArrayList<Tool> tools, int processingTime, KitchenPosition position) {
        this.name = name;
        this.ingredients = ingredients;
        this.tools = tools;
        this.processingTime = processingTime;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<Tool> getTools() {
        return tools;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addTool(Tool tool) {
        tools.add(tool);
    }

    public KitchenPosition getPosition() {
        return position;
    }


}