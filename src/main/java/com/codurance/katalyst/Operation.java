package com.codurance.katalyst;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Operation {

    private float leftOperand;
    private String symbol;
    private float rightOperand;
    private HashMap<String, BinaryOperator<Float>> operations = new HashMap<String, BinaryOperator<Float>>(){
        {
            put("+", (left, right) -> left + right);
            put("*", (left, right) -> left * right);
            put("/", (left, right) -> left / right);
            put("-", (left, right) -> left - right);
        }
    };
    protected Operation(float leftOperand, String symbol, float rightOperand){
        this.leftOperand = leftOperand;
        this.symbol = symbol;
        this.rightOperand = rightOperand;
    }
    public static Operation create(String operation) {
        String[] data = operation.substring(1, operation.length()-1).split(" ", -1);
        return new Operation(Float.valueOf(data[0]), data[1], Float.valueOf(data[2]));
    }
    public float eval(){
        return operations.get(symbol).apply(leftOperand, rightOperand);
    }
}
