package racingcar2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("쉼표로 구분되는 이름 목록에 맞게 자동차를 생성한다.")
    void WhenMultipleCarNamesGiven_Expect_CreateCarList() {
        String input = "pobi,poba,pobe,pobu";
        Cars cars = new Cars(input);
        Assertions.assertThat(cars.equals(new Cars(input))).isTrue();
        Assertions.assertThat(cars.equals(new Cars("poba,pobe,pobu,pobi"))).isFalse();
    }

}
