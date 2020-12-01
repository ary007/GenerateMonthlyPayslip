package com.arijeet.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    public void shouldThrowExpectionWhenInputsAreNotOfSizeTwo() {
        String[] args={"name"};
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateInputs(args);
        });
    }

    @Test
    public void shouldThrowExpectionWhenSecondInputIsNotNumber() {
        String[] args={"name","abcdef"};
        assertThrows(IllegalArgumentException.class, ()->{
            InputValidator.validateInputs(args);
        });
    }

    @Test
    public void shouldNotThrowExpectionWhenCorrectInputIsPassed() {
        String[] args={"name","60000","Australia"};
        InputValidator.validateInputs(args);
    }
}
