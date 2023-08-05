package baseball.validate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidateTest {
    InputValidate inputValidate = new InputValidate();

    @Test
    void number_validate_test(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidate.numbersCheck("1m3");
        });
        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
