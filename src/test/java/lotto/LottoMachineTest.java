package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Util.FixedLottoGenerator;
import lotto.Util.LottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.vaildator.InputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest extends NsTest {

    private static InputView inputView;
    private static OutputView outputView;
    private static InputValidator inputValidator;
    private static LottoGenerator lottoGenerator;

    @BeforeAll
    public static void initMachine() {
        inputView = new InputView();
        outputView = new OutputView();
        inputValidator = new InputValidator();
        lottoGenerator = new FixedLottoGenerator(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("수익률이 매우 높을 때")
    public void runTest() {
        run("2100000000", "1,2,3,4,5,6,", "7");
        assertThat(output()).contains("200000000.0%");
    }

    public void runMain() {
        LottoMachine lottoMachine = new LottoMachine(inputView, outputView, inputValidator, lottoGenerator);
        lottoMachine.run();
    }
}
