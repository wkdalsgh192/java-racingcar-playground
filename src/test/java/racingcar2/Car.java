package racingcar2;

import java.util.Objects;

class Car {

    private Name name;
    private Position position;

    Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    Car(String name, int pos) {
        this.name = new Name(name);
        this.position = new Position(pos);
    }

    Position getPosition() { return position; }

    void move(DrivingStrategy drivingStrategy) {
        position.change(drivingStrategy.isQualified());
    }

    static Car compare(Car o1, Car o2) {
        if (o1.position.isBiggerThan(o2.position)) return o1;
        return o2;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
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
