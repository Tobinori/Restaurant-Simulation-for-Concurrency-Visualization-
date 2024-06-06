package FoodComponents;

public enum ToolList {
    MICROWAVE,
    PLATE,
    SPATULA,
    BREAD_KNIFE_1,
    BREAD_KNIFE_2,
    BREAD_KNIFE_3,
    SMALL_KNIVE,
    HOT_DOG_MACHINE,
    OVEN,
    FRYER,
    TONG,
    ;

    public String getName() {
        return this.name().replace("_", " ");
    }
}
