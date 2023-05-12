package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperationsTest {
    
    @Test
    public void return_zero_when_operations_are_only_brackets(){
        assertEquals(0, Operations.create("((()()))").eval());
    }
}
