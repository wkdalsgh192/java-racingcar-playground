package racingcar;

import org.jetbrains.annotations.NotNull;

class Car {

    private final static int NAME_CONSTRAINT = 5;
    private String name;
    private int pos;

    public Car(@NotNull String name) {
        if (name.length() > NAME_CONSTRAINT) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        this.name = name;
    }

    public Car(@NotNull String name, int pos) {
        if (name.length() > NAME_CONSTRAINT) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public int getPos() { return pos; }

    public void moveTo(int pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        Car other = (Car) o;
        return this.name.equals(other.getName()) && this.pos == other.getPos();
    }
}
