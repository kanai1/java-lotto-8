package lotto.Util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("로또 난수 생성 테스트")
    void generatorTest() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        List<Integer> lotto = lottoGenerator.generate();
        assertThat(lotto.stream().distinct().count()).isEqualTo(6); // 중복확인
        for (Integer num: lotto) {
            assertThat(num).isBetween(1, 45);
        }
    }
}
