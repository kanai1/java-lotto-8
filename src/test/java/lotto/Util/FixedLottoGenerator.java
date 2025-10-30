package lotto.Util;

import java.util.List;

public class FixedLottoGenerator implements LottoGenerator{

    private final List<Integer> fixed;
    public FixedLottoGenerator(List<Integer> fixed) {
        this.fixed = fixed;
    }
    @Override
    public List<Integer> generate() {
        return fixed;
    }
}
