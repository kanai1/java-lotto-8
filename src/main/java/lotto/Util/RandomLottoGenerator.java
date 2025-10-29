package lotto.Util;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator implements LottoGenerator{
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
