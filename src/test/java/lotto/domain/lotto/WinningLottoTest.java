package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    public WinningLotto winningLotto;

    static Stream<Arguments> argumentsForBonusNumberFailTest() {
        return Stream.of(
                Arguments.of("1", "보너스 번호는 로또번호와 중복될 수 없습니다"),
                Arguments.of("0", "보너스 번호는 1부터 45 사이의 숫자여야 합니다"),
                Arguments.of("46", "보너스 번호는 1부터 45 사이의 숫자여야 합니다"),
                Arguments.of("aa", "보너스 번호는 1부터 45 사이의 숫자여야 합니다"),
                Arguments.of(" ", "보너스 번호는 1부터 45 사이의 숫자여야 합니다"),
                Arguments.of("", "보너스 번호는 1부터 45 사이의 숫자여야 합니다")
        );
    }

    @BeforeEach
    public void init(){
        winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("보너스번호 검증 테스트(1,2,3,4,5,6 / 7)")
    public void bonusNumberSuccessTest() {
        assertThatCode(() -> winningLotto.setBonusNumber("7")).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{displayName}(1,2,3,4,5,6 / {0})")
    @MethodSource("argumentsForBonusNumberFailTest")
    @DisplayName("보너스 번호 검증 테스트")
    public void bonusNumberFailTest(String input, String errorMessage) {
        assertThatThrownBy(() -> winningLotto.setBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage);
    }
}
