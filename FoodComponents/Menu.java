package FoodComponents;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {
    public Food createSaltyPie() {
        ArrayList<IngredientsList> ingredients = new ArrayList<>();
        ingredients.add(IngredientsList.SALTY_PIE);
        ArrayList<ToolList> tools = new ArrayList<>();
        tools.add(ToolList.MICROWAVE);
        tools.add(ToolList.BREAD_KNIFE_2);
        tools.add(ToolList.PLATE);
        tools.add(ToolList.SPATULA);
        return new Food(MenuList.SALTY_PIE, ingredients, tools);
    }

    public Food createFriedFish() {
        ArrayList<IngredientsList> ingredients = new ArrayList<>();
        ingredients.add(IngredientsList.FRIED_FISH);
        ingredients.add(IngredientsList.LEMON);
        ingredients.add(IngredientsList.SALAD);
        ingredients.add(IngredientsList.TARTAR_SAUCE);
        ArrayList<ToolList> tools = new ArrayList<>();
        tools.add(ToolList.FRYER);
        return new Food(MenuList.FRIED_FISH_WITH_SALAD, ingredients, tools);
    }

    public Food createHotDog() {
        ArrayList<IngredientsList> ingredients = new ArrayList<>();
        ingredients.add(IngredientsList.BAGUETTE);
        ingredients.add(IngredientsList.KETCHUP);
        ingredients.add(IngredientsList.MAYONNAISE);
        ingredients.add(IngredientsList.MUSTARD);
        ingredients.add(IngredientsList.HOT_DOG_SAUSAGE);
        ArrayList<ToolList> tools = new ArrayList<>();
        tools.add(ToolList.HOT_DOG_MACHINE);
        return new Food(MenuList.HOT_DOG, ingredients, tools);
    }


}
