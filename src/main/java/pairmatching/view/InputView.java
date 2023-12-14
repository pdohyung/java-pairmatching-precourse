package pairmatching.view;

import pairmatching.domain.MatchingOption;
import pairmatching.util.InputValidator;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);
    private static final String INPUT_CHOOSE_FUNCTION_MESSAGE =
            "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
    private static final String INPUT_MATCHING_OPTION = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";

    public String inputChooseFunction() {
        System.out.println(INPUT_CHOOSE_FUNCTION_MESSAGE);
        return InputValidator.validateInputChooseFunction(sc.nextLine());
    }

    public MatchingOption inputMatchingOption() {
        System.out.println(INPUT_MATCHING_OPTION);
        return InputValidator.validateInputMatchingOption(sc.nextLine());
    }
}
