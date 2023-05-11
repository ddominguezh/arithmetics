package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperationTest {
    
    @Test
    public void solve_sum(){
        assertEquals(12, Operation.create("(3 + 9)").eval());
    }

    @Test void solve_multiplication(){
        assertEquals(27, Operation.create("(3 * 9)").eval());
    }
}
