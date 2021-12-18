package racingcar2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void WhenCarNameLengthExceedFive_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @RepeatedTest(5)
    @DisplayName("자동차가 전진하는 경우 위치값이 증가한다.")
    void WhenCarMoves_Expect_PositionValueIncrement() {
        Car car = new Car("pobi");
        car.move();
        boolean result = car.equals(new Car("pobi"));
        Assertions.assertThat(result).isFalse();
    }

    private class Car {

        private Name name;
        private Position position;

        public Car(String name) {
            this.name = new Name(name);
            this.position = new Position(); // 포지션 값과 로직을 모두 객체로 감싼다.
        }

        /*
        * 현재 요구 사항은 랜덤값을 반영. 테스트가 항상 통과하기 위해서는 어떻게?
        * => 파라미터로 랜덤값을 받기.
        * */
        public void move() {
            position.change();
        }

        /*
         * 파라미터로 체크하고, 포지션 값을 늘려주니까 테스트코드가 너무 원시적이다. 보다 객체지향적으로 짜려면 어떻게?
         * => Position 객체를 만들어서 객체 안에서 관련 로직을 체크하기
         * */
/*        public void move(int rand) {
            if (rand >= MOVE_CONSTRAINT) position++;
        }*/
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(name, car.name) && Objects.equals(position, car.position);
        }

        /**
         * You must override hashCode() in every class that overrides equals().Failure to do so will result in a violation of the general contract
         * for Object.hashCode(), which will prevent your class from functioning properly in conjunction with all hash-based collections,
         * including HashMap, HashSet, and Hashtable. (-Joshua Bloch)*/
        @Override
        public int hashCode() {
            return Objects.hash(name, position);
        }

    }

}
