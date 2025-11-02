package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT = "보너스 번호를 입력해 주세요.";

    public int getLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT);
        return purchaseAmountValidator(Console.readLine());
    }

    public String getLottoWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT);
        return Console.readLine();
    }

    public String getLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT);
        return Console.readLine();
    }

    private int purchaseAmountValidator(String input) {
        final int PURCHASE_AMOUNT_UNIT = 1000;
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 숫자로 이루어져야 합니다.");
        }
        if (amount < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException("구매금액은 1000원 이상이여야 합니다.");
        }
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
        return amount;
    }
}
