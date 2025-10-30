package lotto.domain.lotto;

import java.util.List;
import java.util.function.Predicate;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
        bonusNumber = 0;
    }

    public WinningLotto(Lotto lotto) {
        super(lotto);
        bonusNumber = 0;
    }

    public void setBonusNumber(String input) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if(this.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복될 수 없습니다.");
        }
        if(bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getRank(Lotto lotto) {
        if(bonusNumber == 0) {
            throw new IllegalArgumentException("보너스 번호가 초기화되지 않았습니다.");
        }
        int duplicationSize = getDuplicationNumberSize(lotto);
        if (duplicationSize == 6) {
            return 1;
        }
        if (duplicationSize == 5 && lotto.isContain(bonusNumber)) {
            return 2;
        }
        if (duplicationSize >= 3) {
            return 8 - duplicationSize;
        }
        return 0;
    }

    private int getDuplicationNumberSize(Lotto lotto) {
        List<Integer> myLotto = lotto.getNumbers();
        List<Integer> winningLotto = super.getNumbers();

        return myLotto.stream().filter(o -> winningLotto.stream().anyMatch(Predicate.isEqual(o))).toList().size();
    }
}
