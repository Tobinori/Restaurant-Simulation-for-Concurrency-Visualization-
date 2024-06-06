package FoodComponents;
import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    ArrayList<Ingredient> ingredientsInKitchen;
    ArrayList<Tool> toolsInKitchen;

    public Kitchen() {
        ingredientsInKitchen = new ArrayList<Ingredient>();
        toolsInKitchen = new ArrayList<Tool>();
        initializeIngredients();
        initializeTools();
    }

    private void initializeIngredients(){
        for (IngredientsList ingredient : IngredientsList.values()) {
            ingredientsInKitchen.add(new Ingredient(ingredient, ingredient.getStartQuantity()));
        }
    }

    private void initializeTools(){
        for (ToolList tool : ToolList.values()) {
            toolsInKitchen.add(new Tool(tool));
        }
    }

    private boolean ingredientsOutOfStock(Food food)
    {
        boolean foodIsOutOfStock = false;
        List<Ingredient> outOfStock = new ArrayList<Ingredient>();
        for (Ingredient ingredient : ingredientsInKitchen) {
            if (!ingredient.isAvilable()) {
                outOfStock.add(ingredient);
            }
        }
        for (IngredientsList ingredient : food.getIngredients()) {
            Ingredient ingredientDummy = new Ingredient(ingredient);
            if(outOfStock.contains(ingredientDummy))
            {
                foodIsOutOfStock = true;
                break;
            }
        }
        return foodIsOutOfStock;
    }

    private Tool getTool(ToolList tool)
    {
        for (Tool toolInKitchen : toolsInKitchen) {
            if (toolInKitchen.getTool().equals(tool)) {
                return toolInKitchen;
            }
        }
        return null;
    }

    //TODO: Implement the cook method
    //This method should take a Food object as a parameter and make sure that all the ingredients needed for the food are available in the kitchen
    //If an ingredient is not available, the method should throw an exception
    //If all the ingredients are available, the method should use the ingredients and update the quantity of the ingredients in the kitchen
    //The method should also check if all the tools needed for the food are available in the kitchen
    //If a tool is not available, the method should wait until the tool is available¨
    //If all the tools are available, the method should use the tools and update the status of the tools in the kitchen
    //The method should print a message when the food is ready
    //The method should also print a message when a tool is in use
    public void cook(Food food) throws FoodOutOfStockException, InterruptedException{
        long startTime = System.currentTimeMillis();
        long processingTime = food.getProcessingTime();
        if(ingredientsOutOfStock(food))
        {
            throw new FoodOutOfStockException("Food cannot be prepared, some ingredients are out of stock.");
        }
        //TODO: Implement the removeFood method in the OrderManager class
        for (IngredientsList ingredient : food.getIngredients()) {
            for (Ingredient ingredientInKitchen : ingredientsInKitchen) {
                //Maybe better with a hashmap
                if (ingredientInKitchen.getIngredient() == ingredient) {
                    
                    {
                        ingredientInKitchen.useIngredient();
                    }
                }
            }
        }
        for (ToolList tool : food.getTools()) {
            try{getTool(tool).useTool();}
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(processingTime);
        System.out.println("Food " + food.getName() + " is ready.");
        long endTime = System.currentTimeMillis();
        for (ToolList tool : food.getTools()) {
            getTool(tool).releaseTool();
        System.out.println("It took " + (endTime - startTime) + " milliseconds to prepare food " + food.getName() + ".");
        }
    }
}



