package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.Util.LottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.WinningLotto;

public class LottoMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;

    private static final long FIRST_PRICE = 2_000_000_000L;
    private static final long SECOND_PRICE = 30_000_000L;
    private static final long THIRD_PRICE = 1_500_000L;
    private static final long FOURTH_PRICE = 50_000L;
    private static final long FIFTH_PRICE = 5_000L;

    public LottoMachine(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = new LottoFactory(lottoGenerator);
    }

    public void run() {
        int purchaseAmount = initPurchaseAmount();
        List<Lotto> lotto = generateLotto(purchaseAmount / 1000);
        WinningLotto winningLotto = initWinningNumber();
        float result = getResult(purchaseAmount, lotto, winningLotto);

        outputView.printWinningRate(result);
    }

    private int initPurchaseAmount() {
        while(true) {
            try {
                return inputView.getLottoPurchaseAmount();
            }
            catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLotto(int count) {
        List<Lotto> lotto = lottoFactory.generateLotto(count);
        outputView.printPurchasedLottoNumber(lotto);
        return lotto;
    }

    private WinningLotto initWinningNumber() {
        WinningLotto winningLotto = new WinningLotto(getWinningNumber());
        while(true) {
            try {
                String input = inputView.getLottoBonusNumber();
                winningLotto.setBonusNumber(input);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumber() {
        while(true) {
            try {
                String input = inputView.getLottoWinningNumber();
                return Lotto.of(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private float getResult(int purchaseAmount, List<Lotto> lottos, WinningLotto winningLotto) {
        List<Integer> rank = getRanks(lottos, winningLotto);
        long price = rank.get(0) * FIFTH_PRICE +
                rank.get(1) * FOURTH_PRICE +
                rank.get(2) * THIRD_PRICE +
                rank.get(3) * SECOND_PRICE +
                rank.get(4) * FIRST_PRICE;

        return (float) price / purchaseAmount * 100;
    }

    private List<Integer> getRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        Integer[] ranks = {0, 0, 0, 0, 0, 0};

        for (Lotto lotto: lottos) {
            ranks[5 - winningLotto.getRank(lotto)]++;
        }
        outputView.printWinningDetail(Arrays.asList(ranks));
        return Arrays.asList(ranks);
    }
}
