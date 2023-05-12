package com.codurance.katalyst;

public class Operations {

    private String operations;
    protected Operations(String operations){
        this.operations = operations;
    }
    public static Operations create(String operations) {
        return new Operations(operations);
    }

    public Integer eval() {
        return 0;
    }
    
}
