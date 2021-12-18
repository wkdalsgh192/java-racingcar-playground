package racingcar2;

import java.util.Objects;

class Name {

    private final static int NAME_LIMIT = 5;
    private String name;

    public Name(String name) {
        if (isNotValid(name)) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        this.name = name;
    }

    private boolean isNotValid(String name) {
        return name.length() > NAME_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
