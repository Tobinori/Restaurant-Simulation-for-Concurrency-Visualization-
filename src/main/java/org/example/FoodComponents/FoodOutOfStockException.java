package org.example.FoodComponents;

public class FoodOutOfStockException extends Exception{

    public FoodOutOfStockException(String message){
        super(message);
    }

    public FoodOutOfStockException(String message, Throwable cause){
        super(message, cause);
    }

    public FoodOutOfStockException(Throwable cause){
        super(cause);
    }

}
