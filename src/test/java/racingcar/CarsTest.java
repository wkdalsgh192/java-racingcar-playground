package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CarsTest {

    @Test
    @DisplayName("여러 대의 자동차 이름이 주어질 때 쉼표를 기준으로 차가 만들어 진다.")
    void When_CarNamesGiven_Expect_MultipleCarsCreated() {
        Assertions.assertThat(new Cars("pobi,crong,honux").size()).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표가 아닌 다른 구분자가 들어오면 IllegalArgumentException을 발생시킨다.")
    void When_DelimitersExceptCommaGiven_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Cars("pobi.crong,honux").size())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("여러 개의 자동차 이름을 입력할 때에는 반드시 쉼표로만 구분되어야 합니다.");
    }

    private class Cars {

        private List<Car> lot;

        public Cars(String s) {
            lot = new ArrayList<>();
            String[] carList = split(s);
            for (String name : carList) {
                lot.add(new Car(name));
            }
        }

        private String[] split(String input) {
            Pattern pattern = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
            if (pattern.matcher(input).find()) throw new IllegalArgumentException("여러 개의 자동차 이름을 입력할 때에는 반드시 쉼표로만 구분되어야 합니다.");
            return input.split(",");
        }

        public int size() {
            return lot.size();
        }
    }
}
