package com.codurance.katalyst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;

public class Operation {

    private List<String> data;
    private static String[] SYMBOLS_WITH_PRECEDENCE_RULES = new String[] {"*", "/", "+", "-"};
    private HashMap<String, BinaryOperator<Float>> operations = new HashMap<String, BinaryOperator<Float>>(){
        {
            put("*", (left, right) -> left * right);
            put("/", (left, right) -> left / right);
            put("+", (left, right) -> left + right);
            put("-", (left, right) -> left - right);
        }
    };
    protected Operation(List<String> data){
        this.data = data;
    }
    public static Operation create(String operation) {
        if(hasBadFormat(operation)){
            throw new InvalidRecordErrorException();
        }
        String[] data = operation.substring(2, operation.length()-2).split(" ", -1);
        return new Operation(new ArrayList<String>(Arrays.asList(data)));
    }
    private static boolean hasBadFormat(String operation){
        return !operation.startsWith("(")
            || !operation.endsWith(")")
            || !isValidBodyOperation(operation);
    }
    private static boolean isValidBodyOperation(String operation){
        long numbers = Pattern.compile("[-]?(\\d*\\.)?\\d+").matcher(operation).results().count();
        long whiteSpaces = Pattern.compile("\\s").matcher(operation).results().count();;
        long symbols = Pattern.compile("\\s[\\+*\\/-]\\s").matcher(operation).results().count();;
        return numbers == symbols+1 && whiteSpaces == (numbers+symbols+1);
    }
    public float eval(){
        for (String symbol : SYMBOLS_WITH_PRECEDENCE_RULES) {
            float value = 0;
            for( int i = data.size()-1 ; i >= 0; i-- ){
                if(symbol.equals(data.get(i))){
                    value = operations.get(symbol).apply(Float.valueOf(data.get(i - 1)), Float.valueOf(data.get(i + 1)));
                    data.remove(i + 1);
                    data.remove(i);
                    data.remove(i - 1);
                    data.add(i - 1, value + "");
                }
            }
        }
        return Float.valueOf(data.get(0));
    }
}
