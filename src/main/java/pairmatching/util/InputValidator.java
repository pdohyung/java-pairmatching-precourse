package pairmatching.util;

import static pairmatching.util.ErrorMessage.*;

public class InputValidator {
    public static String validateInputChooseFunction(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") &&
                !input.equalsIgnoreCase("Q")) {
            throw new IllegalArgumentException(INVALID_CHOOSE_FUNCTION_MESSAGE.getErrorMessage());
        }
        return input;
    }
}
