package racingcar2;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

class Cars {
    private List<Car> value;

    Cars() { value = new ArrayList<>(); }

    Cars(@NonNull String names) {
        this.value = Arrays.stream(names.split(",")).map(name -> new Car(name) {
            @Override
            public boolean isQualified() {
                return true;
            }
        }).collect(Collectors.toList());
    }

    void move(List<Integer> moveCountList) {
        for (int i = 0; i < moveCountList.size(); i++) {
            Car car = value.get(i);
            for (int j = 0; j < moveCountList.get(i); j++) {
                car.move();
            }
        }
    }

    Car getMaxPosCar() {
        Car init = new Car("") {
            @Override
            public boolean isQualified() {
                return true;
            }
        };
        for (int i = 0; i < value.size(); i++) {
            init = Car.compare(init, value.get(i));
        }
        return init;
    }

    Cars getmaxPosCars() {
        Cars cars = new Cars();
        Position maxPos = getMaxPos();
        for (int i = 0; i < value.size(); i++) {
            Car t = value.get(i);
            if (maxPos.equals(t.getPosition())) cars.add(t);
        }
        return cars;
    }

    void add(Car car) {
        value.add(car);
    }

    Position getMaxPos() {
        Position init = new Position();
        for (int i = 0; i < value.size(); i++) {
            Car car = value.get(i);
            init.update(car.getPosition());
        }
        return init;
    }

    /**
     * List의 equals() 동작 방식:
     * 1. 리스트 사이즈 및 클래스 비교
     * 2. 두 리스트에 담긴 요소 데이터 클래스에 구현된 equals를 활용해 비교 값 비교
     * */
    @Override
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
