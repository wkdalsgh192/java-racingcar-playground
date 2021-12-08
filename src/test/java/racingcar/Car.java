package racingcar;

import org.jetbrains.annotations.NotNull;

class Car {

    private final static int NAME_CONSTRAINT = 5;
    private String name;

    public Car(@NotNull String name) {
        if (name.length() > NAME_CONSTRAINT) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
