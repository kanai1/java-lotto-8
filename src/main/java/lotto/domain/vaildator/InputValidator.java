package lotto.domain.vaildator;

public class InputValidator {
    public void purchaseAmountValidator(String amount) {
        int money;
        try {
            money = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 숫자로 이루어져야 합니다.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }
}
