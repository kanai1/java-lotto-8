package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int COUNT_OF_LOTTO = 6;

    private final List<Integer> numbers;

    public Lotto(Lotto lotto) {
        this.numbers = lotto.getNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 중복되어선 안됩니다");
        }
        if(Collections.max(numbers) > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
        if(Collections.min(numbers) < MINIMUM_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public List<String> getNumbersString() {
        return numbers.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
