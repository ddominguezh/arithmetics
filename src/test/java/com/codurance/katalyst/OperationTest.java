package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OperationTest {
    
    @Test
    public void solve_sum(){
        assertEquals(12, Operation.create("(3 + 9)").eval());
    }

    @Test
    public void solve_multiplication(){
        assertEquals(27, Operation.create("(3 * 9)").eval());
    }

    @Test
    public void solve_division(){
        assertEquals(1.5, Operation.create("(6 / 4)").eval());
    }

    @Test
    public void solve_subtraction(){
        assertEquals(-6, Operation.create("(3 - 9)").eval());
    }

    @Test
    public void invalid_operations_when_not_start_with_bracket(){
        assertThrows(InvalidRecordErrorException.class, () -> {
            Operation.create("3 - 9)").eval();
        });
    }

    @Test
    public void invalid_operations_when_not_ent_with_bracket(){
        assertThrows(InvalidRecordErrorException.class, () -> {
            Operation.create("(3 - 9").eval();
        });
    }
}
