package racingcar;

import java.util.List;

class Racing {

    private Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public void start(List<Integer> list) {
        if (cars.size() != list.size()) throw new RuntimeException("생성된 자동차의 수와 입력된 움직임의 수가 다릅니다.");
        cars.move(list);
    }

    public Cars win() {
        Cars result = cars.getResult();
        Car winner = result.findFirst();
        if (winner.getPos() == 0) throw new RuntimeException("아직 게임이 시작되지 않았습니다.");
        return result.findByPos(winner.getPos());
    }
}
