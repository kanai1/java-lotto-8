package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(Lotto lotto) {
        this.numbers = lotto.getNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    public static Lotto of(String input) {
        List<Integer> numbers;
        try{
            numbers = Stream.of(input.split(",")).map(Integer::parseInt).toList();
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되어선 안됩니다");
        }
        if(Collections.max(numbers) > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
        if(Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getNumbersString() {
        return numbers.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
