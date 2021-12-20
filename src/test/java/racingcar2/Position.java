package racingcar2;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

class Position {
    private final int MOVE_CONSTRAINT = 4;
    private int value = 0;

    Position() {}

    Position(int pos) { this.value = pos; }

    void change(boolean qualified) {
        if (qualified) value++;
    }

    /**
     * 스테틱 메소드로 만들어, 프로덕션 코드에서 Car 인스턴스 생성 시점에 isQualified()의 리턴값으로 사용할 수 있게 만든다.
     * */
    static int getRandNum() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    @Deprecated
    public int getPosition() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MOVE_CONSTRAINT, value);
    }

    void update(Position other) {
        if (other.value > this.value) this.value = other.value;
    }

    boolean isBiggerThan(Position other) {
        if (this.value > other.value) return true;
        return false;
    }
}
