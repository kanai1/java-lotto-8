package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    public Lotto lotto;

    static Stream<Arguments> argumentsForBonusNumberFailTest() {
        return Stream.of(
                Arguments.of(1, "보너스 번호는 로또번호와 중복될 수 없습니다"),
                Arguments.of(0, "보너스 번호는 1부터 45 사이의 숫자여야 합니다"),
                Arguments.of(46, "보너스 번호는 1부터 45 사이의 숫자여야 합니다")
        );
    }

    static Stream<Arguments> argumentsForGetRankTest() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", 1),
                Arguments.of("1,2,3,4,5,7", 2),
                Arguments.of("1,2,3,4,5,41", 3),
                Arguments.of("1,2,3,4,41,42", 4),
                Arguments.of("1,2,3,40,41,42", 5),
                Arguments.of("40,41,42,43,44,45", 0)
        );
    }

    @BeforeEach
    public void init() {
        lotto = new Lotto(Lotto.of("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("보너스 번호 검증 테스트(1,2,3,4,5,6 / 7)")
    public void bonusNumberSuccessTest() {
        assertThatCode(() -> new WinningLotto(lotto, 7)).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{displayName}(1,2,3,4,5,6 / {0})")
    @MethodSource("argumentsForBonusNumberFailTest")
    @DisplayName("보너스 번호 검증 테스트")
    public void bonusNumberFailTest(int input, String errorMessage) {
        assertThatThrownBy(() -> new WinningLotto(lotto, input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage);
    }

    @ParameterizedTest(name = "{displayName}({0}, expected = {1})")
    @MethodSource("argumentsForGetRankTest")
    @DisplayName("당첨결과 테스트")
    public void getRankTest(String input, int expectedRank) {
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        assertThat(winningLotto.getRank(Lotto.of(input))).isEqualTo(expectedRank);
    }
}
