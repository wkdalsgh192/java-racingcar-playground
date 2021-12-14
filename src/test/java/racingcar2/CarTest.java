package racingcar2;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void WhenCarNameLengthExceedFive_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차가 전진하는 경우 위치값이 증가한다.")
    void WhenCarMoves_Expect_PositionValueIncrement() {
        Car car = new Car("pobi");
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    private class Car {

        private final int MOVE_CONSTRAINT = 3;
        private Name name;
        private int position;

        public Car(String name) {
            this.name = new Name(name);
            this.position = 0;
        }

        public void move() {
            if (getRandNum() > MOVE_CONSTRAINT) position++;
        }

        private int getRandNum() {
            return ThreadLocalRandom.current().nextInt(10);
        }

        public int getPosition() { return this.position; }
    }

}
