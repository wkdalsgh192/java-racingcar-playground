package racingcar2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void WhenCarNameLengthExceedFive_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Car("pobipobi")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @RepeatedTest(5)
    @DisplayName("자동차가 전진하는 경우 위치값이 증가한다.")
    void WhenCarMoves_Expect_PositionValueIncrement() {
        Car car = new Car("pobi");
        car.move(() -> true);
        boolean result = car.equals(new Car("pobi"));
        Assertions.assertThat(result).isFalse();
    }
}
