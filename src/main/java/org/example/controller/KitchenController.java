package org.example.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class KitchenController {

    ValueHandler valueHandler;

    public KitchenController(){
        this.valueHandler = new ValueHandler();
    }


    public void initialize(){
        memoryDiego.textProperty().bind(valueHandler.getMemoryDiego());
        memoryEvelyn.textProperty().bind(valueHandler.getMemoryEvelyn());
        memoryRichi.textProperty().bind(valueHandler.getMemoryRichi());
        memoryYoga.textProperty().bind(valueHandler.getMemoryYoga());
    }
    

    @FXML
    private TextArea memoryDiego;

    @FXML
    private TextArea memoryEvelyn;

    @FXML
    private TextArea memoryRichi;

    @FXML
    private TextArea memoryYoga;

    @FXML
    private TextField numberToAddOrder;

    @FXML
    private TextArea orderInTaking;

    @FXML
    private TextField orderNumberBottomLeft;

    @FXML
    private TextField orderNumberBottomRight;

    @FXML
    private TextField orderNumberMiddleLeft;

    @FXML
    private TextField orderNumberMiddleRight;

    @FXML
    private TextField orderNumberTopLeft;

    @FXML
    private TextField orderNumberTopRight;

    @FXML
    private TextArea orderOpenTopLeft;

    @FXML
    private TextArea orderOpenTopRight;

    @FXML
    private TextArea openOrderBottomLeft;

    @FXML
    private TextArea openOrderBottomRight;

    @FXML
    private TextArea openOrderMiddleLeft;

    @FXML
    private TextArea openOrderMiddleRight;

    @FXML
    void addOrder(ActionEvent event) {

    }

    @FXML
    void placeOrder(ActionEvent event) {

    }

}
