package racingcar2;

import java.util.Objects;

abstract class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move() {
        position.change(isQualified());
    }

    /**
     * 추상 메소드를 사용해, 인스턴스 생성 시점에 이를 구현함으로써 테스트 코드 작성 시점까지 로직 구현을 유보할 수 있다.
     * 보다 유연한 테스트 환경 구축 가능.
     */
    public abstract boolean isQualified();

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
     * including HashMap, HashSet, and Hashtable. (-Joshua Bloch)
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }


}
