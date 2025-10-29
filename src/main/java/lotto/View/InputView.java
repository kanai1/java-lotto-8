package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT = "보너스 번호를 입력해 주세요.";

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
}
