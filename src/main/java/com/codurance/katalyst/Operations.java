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

    public Integer eval() {
        if(isOnlyBracket()){
            return 0;
        }
        return 0;
    }
    
    private boolean isOnlyBracket(){
        Matcher matcher = Pattern.compile("[\\(\\)]+").matcher(operations);
        Optional<MatchResult> result = matcher.results().findFirst();
        return result.isPresent() && operations.equals(result.get().group());
    }
}
