package com.codurance.katalyst;

public class InvalidRecordErrorException extends RuntimeException{
    
    public InvalidRecordErrorException(){
        super("Invalid record error");
    }
}
