package lotto.domain.valitador;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.domain.vaildator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidatorTest {

    public InputValidator inputValidator;

    static Stream<Arguments> argumentsForPurchaseAmountValidatorTest() {
        return Stream.of(
                Arguments.of("10001", "구매금액은 1000원 단위로 나누어 떨어져야 합니다"),
                Arguments.of("1000원", "구매금액은 숫자로 이루어져야 합니다"),
                Arguments.of(" ", "구매금액은 숫자로 이루어져야 합니다"),
                Arguments.of("", "구매금액은 숫자로 이루어져야 합니다"),
                Arguments.of("-1000", "구매금액은 1000원 이상이여야 합니다")
        );
    }

    @BeforeEach
    public void init() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest(name = "{displayName}({0})")
    @MethodSource("argumentsForPurchaseAmountValidatorTest")
    @DisplayName("구매금액 검증테스트")
    public void purchaseAmountValidatorTest(String input, String errorMessage) {
        assertThatThrownBy(() -> inputValidator.purchaseAmountValidator(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage);

    }
}