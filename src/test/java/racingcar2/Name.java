package racingcar2;

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
}
