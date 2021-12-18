package racingcar2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarsTest {

    @Test
    @DisplayName("쉼표로 구분되는 이름 목록에 맞게 자동차를 생성한다.")
    void WhenMultipleCarNamesGiven_Expect_CreateCarList() {
        String input = "pobi,poba,pobe,pobu";
        Cars cars = new Cars(input);
        Assertions.assertThat(cars.equals(new Cars(input))).isTrue();
        Assertions.assertThat(cars.equals(new Cars("poba,pobe,pobu,pobi"))).isFalse();
    }

    private class Cars {
        private List<Car> value;

        public Cars(String names) {
            this.value = Arrays.stream(names.split(",")).map(name -> new Car(name) {
                @Override
                public boolean isQualified() {
                    return true;
                }
            }).collect(Collectors.toList());
        }


        @Override
        /**
         * List의 equals() 동작 방식:
         * 1. 리스트 사이즈 및 클래스 비교
         * 2. 두 리스트에 담긴 요소 데이터 클래스에 구현된 equals를 활용해 비교 값 비교
         * */
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cars cars = (Cars) o;
            return Objects.equals(value, cars.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
