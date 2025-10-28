package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    private static final String LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_NUMBER_OUTPUT_STATEMENT = "개를 구매했습니다.";
    private static final List<String> WINNING_DETAIL_OUTPUT_STATEMENTS = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );
    private static final String WINNING_RATE_OUTPUT_STATEMENT = "총 수익율은 %.1f%%입니다.\n";

    public String getLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT);
        return Console.readLine();
    }

    public String getLottoWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT);
        return Console.readLine();
    }

    public String getLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT);
        return Console.readLine();
    }

    public void printPurchasedLottoNumber(List<Lotto> tickets) {
        System.out.println(tickets.size() + PURCHASED_LOTTO_NUMBER_OUTPUT_STATEMENT);
        for (Lotto lotto: tickets) {
            System.out.println("["+String.join(", ", String.join(", ", lotto.getNumbersString()))+"]");
        }
    }

    public void printWinningDetail(List<Integer> rank) {
        for (int i = 0; i < 5; i++) {
            System.out.printf(WINNING_DETAIL_OUTPUT_STATEMENTS.get(i), rank.get(i));
        }
    }

    public void printWinningRate(float winningRate) {
        System.out.printf(WINNING_RATE_OUTPUT_STATEMENT, winningRate);
    }
}
