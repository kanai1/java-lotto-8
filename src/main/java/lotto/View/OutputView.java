package lotto.View;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class OutputView {

    private static final String PURCHASED_LOTTO_NUMBER_OUTPUT_STATEMENT = "개를 구매했습니다.";
    private static final List<String> WINNING_DETAIL_OUTPUT_STATEMENTS = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );
    private static final String WINNING_RATE_OUTPUT_STATEMENT = "총 수익율은 %.1f%%입니다.\n";
    private static final String ERROR_OUTPUT_STATEMENT = "[ERROR] %s\n";

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

    public void printError(String errorMessage) {
        System.out.printf(ERROR_OUTPUT_STATEMENT, errorMessage);
    }
}
