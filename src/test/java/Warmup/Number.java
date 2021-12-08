package Warmup;

class Number {

    private int value = 0;

    public Number(Integer num) {
        if (num < 0) throw new RuntimeException("음수는 처리할 수 없습니다.");
        this.value = num;
    }

    public Number() {
    }

    public void add(Number number) {
        this.value += number.getNumericValue();
    }

    int getNumericValue() {
        return value;
    }
}
