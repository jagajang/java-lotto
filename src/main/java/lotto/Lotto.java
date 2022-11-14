package lotto;

import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.IO.message.ErrorCode;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.WRONG_SIZE.getErrorMessage());
        }

        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(ErrorCode.OUT_RANGE.getErrorMessage());
            }
            if(numbers.subList(0, i).contains(numbers.get(i))) {
                throw new IllegalArgumentException(ErrorCode.DUPLICATE.getErrorMessage());
            }
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNum.sort(Comparator.naturalOrder());
        return lottoNum;
    }

    public int compareWithAnswer(Lotto answer, int bonus) {
        int correct = 0;

        for(int num : numbers) {
            if(answer.contains(num))
                correct++;
        }

        return rank(correct, numbers.contains(bonus));
    }

    public static int rank(int correct, boolean bonus) {
        if(correct == 6)
            return 1;
        if(correct == 5 && bonus)
            return 2;
        if(correct == 5)
            return 3;
        if(correct == 4)
            return 4;
        if(correct == 3)
            return 5;

        return -1;
    }
}
