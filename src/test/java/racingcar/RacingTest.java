package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingTest {

    private Cars cars;
    private  Racing racing;

    @BeforeEach
    void setup() {
        cars = new Cars("pobi,crong,honux");
        racing = new Racing(cars);
    }

    @Test
    @DisplayName("각각의 자동차가 정해진 횟수동안 몇 번 움직였는 지 안다면, 우승자를 반환한다.")
    void When_EachCarMovementGiven_Expect_RacingResult() {
        racing.start(Arrays.asList(3,5,4));
        Assertions.assertThat(racing.win().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승한 자동차가 한 개일 때, 우승자를 반환한다.")
    void When_RacingHasOneWinner_Return_RacingResult() {
        racing.start(Arrays.asList(3,5,4));
        Assertions.assertThat(racing.win().equals(List.of(new Car("crong",5)))).isTrue();
    }

    @Test
    @DisplayName("우승한 자동차가 두 개이상일 때, 우승자를 반환한다.")
    void When_RacingHasTwoWinners_Return_RacingResultAsList() {
        racing.start(Arrays.asList(3,5,5));
        Assertions.assertThat(racing.win().equals(new Cars("crong,honux"))).isTrue();
    }

    @Test
    @DisplayName("생성된 자동차의 수와 움직인 수가 다르면 예외를 발생시킨다.")
    void When_CarsAndMovementCntDifferent_Throw_RuntimeException() {
        Assertions.assertThatThrownBy(() -> racing.start(Arrays.asList(3,5))).isInstanceOf(RuntimeException.class).hasMessageContaining("생성된 자동차의 수와 입력된 움직임의 수가 다릅니다.");
    }

    @Test
    @DisplayName("정해진 횟수동안 모두 0번 움직였다면 아직 게임이 시작되지 않은 것이다.")
    void When_NoCarsMove_Throw_RuntimException() {
        Assertions.assertThatThrownBy(() -> {
            racing.start(Arrays.asList(0,0,0));
            racing.win();
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("아직 게임이 시작되지 않았습니다.");
    }

    private class Racing {

        private Cars cars;

        public Racing(Cars cars) {
            this.cars = cars;
        }

        public void start(List<Integer> list) {
            if (cars.size() != list.size()) throw new RuntimeException("생성된 자동차의 수와 입력된 움직임의 수가 다릅니다.");
            cars.move(list);
        }

        public Cars win() {
            Cars result = cars.getResult();
            Car winner = result.findFirst();
            if (winner.getPos() == 0) throw new RuntimeException("아직 게임이 시작되지 않았습니다.");
            return result.findByPos(winner.getPos());
        }
    }
}
