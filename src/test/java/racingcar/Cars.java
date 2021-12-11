package racingcar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Cars {

    private List<Car> lot;

    public Cars(String s) {
        lot = new ArrayList<>();
        String[] carList = split(s);
        for (String name : carList) {
            lot.add(new Car(name));
        }
    }

    public Cars(List<Car> carList) {
        lot = carList;

    }

    private String[] split(String input) {
        Pattern pattern = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
        if (pattern.matcher(input).find())
            throw new IllegalArgumentException("여러 개의 자동차 이름을 입력할 때에는 반드시 쉼표로만 구분되어야 합니다.");
        return input.split(",");
    }

    public int size() {
        return lot.size();
    }

    public Cars getResult() {
        return Cars.from(lot.stream().sorted(
            Comparator.comparing(Car::getPos).reversed()
        ).collect(Collectors.toList()));
    }

    private static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    public void move(List<Integer> moveList) {
        for (int i = 0; i < lot.size(); i++) {
            Car car = lot.get(i);
            car.moveTo(moveList.get(i));
        }
    }

    public Car findFirst() {
        return lot.stream().findFirst().get();
    }

    public Cars findByPos(int pos) {
        return Cars.from(lot.stream().filter(car -> car.getPos() == pos).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;

        if (!(o instanceof Cars)) return false;

        Cars other = (Cars) o;

        for (Car car : other.lot) {
            if (!contains(car)) return false;
        }
        return true;
    }

    private boolean contains(Car other) {
        for (Car car : lot) {
            if (car.equals(other)) return true;
        }
        return false;
    }
}
