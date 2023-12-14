package pairmatching.util;

public enum ErrorMessage {
    INVALID_CHOOSE_FUNCTION_MESSAGE("잘못된 기능 입력입니다. 다시 입력해 주세요."),
    INVALID_COURSE_MESSAGE("잘못된 과정입니다. 다시 입력해 주세요."),
    INVALID_LEVEL_MESSAGE("잘못된 레벨입니다. 다시 입력해 주세요."),
    INVALID_MISSION_MESSAGE("잘못된 미션입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
