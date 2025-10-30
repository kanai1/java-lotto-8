package lotto.Util;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator implements LottoGenerator{

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int COUNT_OF_LOTTO = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, COUNT_OF_LOTTO);
    }
}
