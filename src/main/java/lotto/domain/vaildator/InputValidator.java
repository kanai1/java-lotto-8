package lotto.domain.vaildator;

public class InputValidator {
    public int purchaseAmountValidator(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 숫자로 이루어져야 합니다.");
        }
        if (amount < 1000) {
            throw new IllegalArgumentException("구매금액은 1000원 이상이여야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
        return amount;
    }
}
