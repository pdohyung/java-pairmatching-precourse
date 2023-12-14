package pairmatching.util;

public enum ErrorMessage {
    INVALID_CHOOSE_FUNCTION_MESSAGE("잘못된 기능 입력입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
