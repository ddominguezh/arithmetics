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
        if(isOnlyBracket()){
            return 0;
        }
        if(isOneNumberWthBracket()){
            return Float.valueOf(this.operations.substring(2, this.operations.length()-2));
        }
        return Float.valueOf(this.operations);
    }
    
    private boolean isOnlyBracket(){
        Matcher matcher = Pattern.compile("[\\(\\)]+").matcher(operations);
        Optional<MatchResult> result = matcher.results().findFirst();
        return result.isPresent() && operations.equals(result.get().group());
    }

    private boolean isOneNumberWthBracket(){
        return Pattern.compile("\\(\\s-?\\d+\\s\\)").matcher(operations).matches();
    }
}
