package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
        bonusNumber = 0;
    }

    public WinningLotto(Lotto lotto) {
        super(lotto);
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
}
