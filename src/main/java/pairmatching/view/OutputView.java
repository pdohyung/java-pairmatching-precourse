package pairmatching.view;

import java.util.List;

import static java.text.MessageFormat.*;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] {0}";
    private static final String PRINT_RESET_PAIR_MATCHING_MESSAGE = "\n초기화 되었습니다.";
    private static final String PRINT_PAIR_MATCHING_RESULT_START_MESSAGE = "\n페어 매칭 결과입니다.";
    private static final String PRINT_COURSE_AND_MISSION_MESSAGE = "\n#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################";

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printCourseAndMission() {
        System.out.println(PRINT_COURSE_AND_MISSION_MESSAGE);
    }

    public void printPairMatchingResult(List<String> pairResult) {
        System.out.println(PRINT_PAIR_MATCHING_RESULT_START_MESSAGE);
        pairResult.forEach(System.out::println);
    }

    public void printResetPairMatching(){
        System.out.println(PRINT_RESET_PAIR_MATCHING_MESSAGE);
    }
}
