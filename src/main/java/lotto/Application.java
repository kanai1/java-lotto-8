package lotto;

import lotto.Util.LottoGenerator;
import lotto.Util.RandomLottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.vaildator.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        LottoMachine lottoMachine = new LottoMachine(
                inputView,
                outputView,
                inputValidator,
                lottoGenerator);

        lottoMachine.run();
    }
}
