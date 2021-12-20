package racingcar2;

import java.util.List;

class Race {

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
