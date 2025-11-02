package lotto.View;

import static lotto.Config.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    private static final String LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT = "보너스 번호를 입력해 주세요.";

    public int getLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_OUTPUT_STATEMENT);
        return validatePurchaseAmount(Console.readLine());
    }

    public List<Integer> getLottoWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_OUTPUT_STATEMENT);
        return parseLottoWinningNumber(Console.readLine());
    }

    public int getLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_OUTPUT_STATEMENT);
        return parseBonusNumber(Console.readLine());
    }

    private int validatePurchaseAmount(String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 숫자로 이루어져야 합니다.");
        }
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매금액은 1000원 이상이여야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
        return amount;
    }

    private List<Integer> parseLottoWinningNumber(String input) {
        List<Integer> numbers;
        try{
            numbers = Stream.of(input.split(",")).map(Integer::parseInt).toList();
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
