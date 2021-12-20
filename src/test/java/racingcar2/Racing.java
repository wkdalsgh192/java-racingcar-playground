package racingcar2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class Racing {

    @ParameterizedTest
    @DisplayName("자동차들이 각각 몇 번 움직였을 때 우숭한 자동차를 알 수 있다.")
    @ValueSource(strings = {"pobi,poba,pobe,pobu"})
    void doRacing_WhenCarsMove_Expect_GetWinnerCar(String input) {
        Cars cars = new Cars(input);
        Race race = Race.readyInLine(cars);
        race.start(Arrays.asList(3,5,4,1));

        Car winner = race.announceWinner();
        Assertions.assertThat(winner.equals(new Car("poba", 5) {
            @Override
            public boolean isQualified() {
                return true;
            }
        })).isTrue();
    }

    @Test
    @DisplayName("가장 많이 움직인 자동차들이 여럿일 때 우승한 자동차 리스트를 알 수 있다.")
    void doRacing_WhenCarsMove_Expect_GetWinnerCarList() {
        String input = "pobi,poba,pobe,pobu";
        Cars cars = new Cars(input);
        Race race = Race.readyInLine(cars);
        race.start(Arrays.asList(3,5,5,1));

        Cars winnerCars = race.announceWinnerCars();
        Cars expected = new Cars();
        expected.add(new Car("poba", 5) {
            @Override
            public boolean isQualified() {
                return true;
            }
        });
        expected.add(new Car("pobe", 5) {
            @Override
            public boolean isQualified() {
                return true;
            }
        });
        Assertions.assertThat(winnerCars.equals(expected)).isTrue();
    }

    private static class Race {

        private Cars cars;

        Race(Cars cars) {
            this.cars = cars;
        }

        static Race readyInLine(Cars cars) {
            return new Race(cars);
        }

        void start(List<Integer> moveCountList) {
            cars.move(moveCountList);
        }

        Car announceWinner() {
            return cars.getMaxPosCar();
        }

        Cars announceWinnerCars() {
            return cars.getmaxPosCars();
        }
    }
}
