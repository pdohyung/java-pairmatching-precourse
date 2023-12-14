package pairmatching.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"5", "a", "b", "12"})
    void 선택한_기능이_올바르지_않은_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputChooseFunction(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"웹개발, 레벨1, 자동차경주", "백엔드, 레벨6, 자동차경주", "백엔드, 레벨2, 배달"})
    void 매칭_옵션이_올바르지_않은_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputMatchingOption(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}