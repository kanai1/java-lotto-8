package lotto;

import lotto.Util.LottoGenerator;
import lotto.Util.RandomLottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Config {

    public static final int LOTTO_PRICE = 1000;

    public static LottoMachine getMachine() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new RandomLottoGenerator();

        return new LottoMachine(
                inputView,
                outputView,
                lottoGenerator);
    }
}
