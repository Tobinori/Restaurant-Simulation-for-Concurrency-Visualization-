package org.example.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ValueHandler {
    private StringProperty memoryDiego;
    private StringProperty memoryEvelyn;
    private StringProperty memoryRichi;
    private StringProperty memoryYoga;
    private String openMemoryTopLeft;
    private String openMemoryTopRight;
    private String openMemoryBottomLeft;
    private String openMemoryBottomRight;
    private String openMemoryMiddleLeft;
    private String openMemoryMiddleRight;

    public ValueHandler(){
        this.memoryDiego = new SimpleStringProperty();
        this.memoryEvelyn = new SimpleStringProperty();
        this.memoryRichi = new SimpleStringProperty();
        this.memoryYoga = new SimpleStringProperty();
    }

    public void setMemoryDiego(String memoryDiego) {
        this.memoryDiego.set(memoryDiego);
    }
    public void setMemoryEvelyn(String memoryEvelyn) {
        this.memoryEvelyn.set(memoryEvelyn);
    }

    public void setMemoryRichi(String memoryRichi) {
        this.memoryRichi.set(memoryRichi);
    }
    public void setMemoryYoga(String memoryYoga) {
        this.memoryYoga.set(memoryYoga);
    }

    public StringProperty getMemoryDiego() {
        return memoryDiego;
    }
    public StringProperty getMemoryEvelyn() {
        return memoryEvelyn;
    }
    public StringProperty getMemoryRichi() {
        return memoryRichi;
    }
    public StringProperty getMemoryYoga() {
        return memoryYoga;
    }
}
