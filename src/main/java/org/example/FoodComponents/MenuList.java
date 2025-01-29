package org.example.FoodComponents;

import org.example.ProcessingFood.ProcessingFood.KitchenPosition;

public enum MenuList {
    SALAD(2, KitchenPosition.SALAD_STATION),
    SALTY_PIE(5, KitchenPosition.GRILL),
    FRIED_FISH_WITH_SALAD(6, KitchenPosition.STOVE),
    HOT_DOG(2, KitchenPosition.GRILL),
    LONG_JOHN(6, KitchenPosition.GRILL),
    PEPITO(4, KitchenPosition.GRILL),
    STEAK(7, KitchenPosition.GRILL),
    BAKED_POTATO(3, KitchenPosition.SALAD_STATION),
    STEAK_WITH_SALAD(8, KitchenPosition.GRILL),
    BREAD_SALAD(4, KitchenPosition.SALAD_STATION),
    POTATO_SALAD(1, KitchenPosition.SALAD_STATION),
    CARRIOT_SALAD(1, KitchenPosition.SALAD_STATION),
    TABOULE(1, KitchenPosition.SALAD_STATION),
    SALTY_PIE_WITH_SALAD(5, KitchenPosition.GRILL),
    BAKED_POTATO_WITH_SALAD(3, KitchenPosition.SALAD_STATION),
    PORK_SAUSAGE_WITH_POTATO_SALAD(6, KitchenPosition.GRILL),
    PORK_SAUSAGE(6, KitchenPosition.GRILL),;

    private final int preperationTime;
    private final KitchenPosition kitchenPosition;

    MenuList(final int preperationTime, final KitchenPosition kitchenPosition) {
        this.preperationTime = preperationTime;
        this.kitchenPosition = kitchenPosition;
    }

    private MenuList() {
        this.preperationTime = 0;
        this.kitchenPosition = null;
    }

    public int getPreperationTime() {
        return preperationTime;
    }

    public KitchenPosition getKitchenPosition() {
        return kitchenPosition;
    }

    public String getName() {
        return this.name().replace("_", " ");
    }




    
}
