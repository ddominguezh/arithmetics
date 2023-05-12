package com.codurance.katalyst;

public class Operation {

    private float leftOperand;
    private String simbol;
    private float rightOperand;
    protected Operation(float leftOperand, String simbol, float rightOperand){
        this.leftOperand = leftOperand;
        this.simbol = simbol;
        this.rightOperand = rightOperand;
    }
    public static Operation create(String operation) {
        String[] data = operation.substring(1, operation.length()-1).split(" ", -1);
        return new Operation(Float.valueOf(data[0]), data[1], Float.valueOf(data[2]));
    }
    public float eval(){
        if("*".equals(simbol)){
            return leftOperand * rightOperand;
        }
        if("/".equals(simbol)){
            return leftOperand / rightOperand;
        }
        if("-".equals(simbol)){
            return leftOperand - rightOperand;
        }
        return leftOperand + rightOperand;
    }
}
