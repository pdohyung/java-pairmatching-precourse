package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.InputValidator;

public class InputView {
    private static final String INPUT_CHOOSE_FUNCTION_MESSAGE =
            "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

    public String chooseFunction() {
        System.out.println(INPUT_CHOOSE_FUNCTION_MESSAGE);
        return InputValidator.validateInputChooseFunction(Console.readLine());
    }
}
