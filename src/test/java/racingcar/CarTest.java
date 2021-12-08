package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static void call() {
        new Car("pobipobi").getName();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 주어지면 이름을 가진 자동차가 생성된다.")
    @ValueSource(strings = {"pobi","crong","honux"})
    void When_CarNameGiven_MakeCarAndReturnName(String input) {
        Assertions.assertThat(new Car(input).getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("이름이 5자를 넘으면 예외가 발생한다.")
    void When_CarNameOverFiveCharactersGiven_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(CarTest::call).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}
