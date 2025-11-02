package lotto;

import lotto.Util.LottoGenerator;
import lotto.Util.RandomLottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        LottoMachine lottoMachine = new LottoMachine(
                inputView,
                outputView,
                lottoGenerator);

        lottoMachine.run();
    }
}
