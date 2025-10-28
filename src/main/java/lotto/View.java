package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    private static final String LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_NUMBER_OUTPUT_STATEMENT = "개를 구매했습니다.";

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
}
