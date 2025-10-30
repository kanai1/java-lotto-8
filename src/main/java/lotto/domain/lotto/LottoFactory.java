package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.LottoGenerator;

public class LottoFactory {

    private final LottoGenerator lottoGenerator;

    public LottoFactory(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto(lottoGenerator.generate()));
        }

        return lotto;
    }
}
