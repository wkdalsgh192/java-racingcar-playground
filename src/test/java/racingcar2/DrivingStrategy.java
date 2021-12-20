package racingcar2;

public interface DrivingStrategy {
    /**
     * 추상 메소드를 사용해, 인스턴스 생성 시점에 이를 구현함으로써 테스트 코드 작성 시점까지 로직 구현을 유보할 수 있다.
     * 보다 유연한 테스트 환경 구축 가능.
     */
    boolean isQualified();
}
