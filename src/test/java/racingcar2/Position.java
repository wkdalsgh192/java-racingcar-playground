package racingcar2;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

class Position {
    private final int MOVE_CONSTRAINT = 4;
    int value = 0;

    Position() {}

    void change() {
        if (getRandNum() >= MOVE_CONSTRAINT) value++;
    }

    private int getRandNum() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    @Deprecated
    // Getter로 객체의 값을 무조건 가지고 오기보다 타겟 객체에 메시지를 보낼 수는 없을까?
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
}
