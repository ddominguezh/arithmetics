package com.codurance.katalyst;

import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

    private String operations;
    protected Operations(String operations){
        this.operations = operations;
    }
    public static Operations create(String operations) {
        return new Operations(operations);
    }

    public float eval() {
        if(isDifferentNumbersOfBracket()){
            throw new InvalidRecordErrorException();
        }
        if(isOnlyBracket()){
            return 0;
        }
        if(isOneNumberWithBracket()){
            return Float.valueOf(this.operations.substring(2, this.operations.length()-2));
        }
        if(isOnlyNumber()){
            return Float.valueOf(this.operations);
        }
        int firstRightBracket = this.operations.indexOf(")") + 1;
        int lastLeftBracketBeforeFirstRightBracket = this.operations.substring(0, firstRightBracket).lastIndexOf("(");
        float valueOperation = Operation.create(operations.substring(lastLeftBracketBeforeFirstRightBracket, firstRightBracket)).eval();
        return Operations.create(
            this.operations.substring(0, lastLeftBracketBeforeFirstRightBracket) 
            + valueOperation
            + this.operations.substring(firstRightBracket)
        ).eval();
    }
    
    private boolean isDifferentNumbersOfBracket(){
        long openBrackets = Pattern.compile("\\(").matcher(operations).results().count();
        long closeBrackets = Pattern.compile("\\)").matcher(operations).results().count();
        return openBrackets != closeBrackets;
    }

    private boolean isOnlyBracket(){
        Matcher matcher = Pattern.compile("[\\(\\)]+").matcher(operations);
        Optional<MatchResult> result = matcher.results().findFirst();
        return result.isPresent() && operations.equals(result.get().group());
    }

    private boolean isOneNumberWithBracket(){
        return Pattern.compile("\\(\\s[-]?(\\d*\\.)?\\d+\\s\\)").matcher(operations).matches();
    }

    private boolean isOnlyNumber(){
        return Pattern.compile("[-]?(\\d*\\.)?\\d+").matcher(operations).matches();
    }
}
