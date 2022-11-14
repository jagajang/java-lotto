package lotto;

import lotto.IO.message.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Nested
    @DisplayName("로또 번호 생성 테스트")
    class LottoGenerateTest {
        @Test
        @DisplayName("로또 번호가 seed 대로 생성되지 않으면 예외가 발생한다.")
        void generateRandomLottoNumber() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        assertThat(Lotto.generateRandomLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }
    }

    @Nested
    @DisplayName("입출력 테스트")
    class IOTest {
        //@Test
        //@DisplayName("")
    }

    @Test
    @DisplayName("에러 코드가 올바르게 출력되는지 확인한다.")
    void checkErrorMessage() {
        String expectedResult = "[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

        assertThat(ErrorCode.OUT_RANGE.getValue()).isEqualTo(expectedResult);
    }
}
