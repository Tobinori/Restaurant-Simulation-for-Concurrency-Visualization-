package FoodComponents;

import java.util.concurrent.atomic.AtomicInteger;

public enum IngredientsList {
    SALTY_PIE(true, 24),
    PORK_SAUSAGE(true,100),
    BEEF(true, 150),
    STEAK(true, 15),
    BAKED_POTATO(false, 20),
    BAGUETTE(false, 200),
    KETCHUP(false,200),
    MAYONNAISE(false, 200),
    MUSTARD(false, 200),
    SALAD(false, 100),
    TABOULE(false, 20),
    POTATO_SALAD(false, 30),
    CARRIOT_SALAD(false, 20),
    BREAD_SALAD(false, 25),
    HOT_DOG_SAUSAGE(true, 300),
    FRIED_FISH(true, 20),
    PEPITO_SAUCE(false, 200),
    LONG_JOHN_SAUCE(false, 80),
    TARTAR_SAUCE(false, 20),
    LEMON(false, 20),
    SAUERKRAUT(false, 20),
    ;

    private final boolean isKeyIngredient;
    private final AtomicInteger startQuantity;

    IngredientsList(final boolean isKeyIngredient, final int startQuantity) {
        this.isKeyIngredient = isKeyIngredient;
        this.startQuantity = new AtomicInteger(startQuantity);
    }

    public boolean isKeyIngredient() {
        return isKeyIngredient;
    }

    public AtomicInteger getStartQuantity() {
        return startQuantity;
    }

    public String getName() {
        return this.name().replace("_", " ");
    }


}
