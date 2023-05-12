package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperationsTest {
    
    @Test
    public void return_zero_when_operations_are_only_brackets(){
        assertEquals(0, Operations.create("((()()))").eval());
    }

    @Test
    public void return_value_when_operations_is_only_number_between_bracket(){
        assertEquals(14, Operations.create("( 14 )").eval());
    }
    
    @Test
    public void return_value_when_operations_is_only_number(){
        assertEquals(14, Operations.create("14").eval());
    }

    @Test
    public void calculate_arithmetic_operation(){
        assertEquals(101, Operations.create("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )").eval());
    }

    @Test
    public void calculate_arithmetic_operation_whit_precedence_rules(){
        assertEquals(-165, Operations.create("( 5 * ( 4 * ( 3 * ( 2 * ( 1 * 9 ) / 8 - 7 ) + 6 ) ) )").eval());
    }

    @Test
    public void different_number_of_open_and_closed_brackets(){
        assertEquals(-165, Operations.create("( 5 * ( 4 * ( 3 * ( 2 * ( 1 * 9 ) / 8 - 7 + 6 ) ) )").eval());
    }
}
