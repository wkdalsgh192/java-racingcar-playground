package warmup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("빈 문자열이나 null이 들어오면 0을 반환한다.")
    void Should_ReturnZero_When_EmptySpaceOrNull() {
        Assertions.assertThat(calculator.calc("")).isEqualTo(0);
        Assertions.assertThat(calculator.calc(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 하나만 들어오면 그대로 반환한다.")
    void Should_ReturnOriginNumber_When_OneDigit() {
        Assertions.assertThat(calculator.calc("1")).isEqualTo(1);
        Assertions.assertThat(calculator.calc("10")).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 구분자에 대해 분리해 합했을 때 모두 더한 값 반환")
    void Should_ReturnValueAddedByNumbers_Given_DefaultSeparator() {
        Assertions.assertThat(calculator.calc("1,2,3")).isEqualTo(6);
        Assertions.assertThat(calculator.calc("3:4:5")).isEqualTo(12);
        Assertions.assertThat(calculator.calc("6,7:8")).isEqualTo(21);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용핼을 때 파싱해서 값을 더하기")
    void When_CustomDelimitersGiven_Expect_ParseAndAddNumbers() {
        Assertions.assertThat(calculator.calc("//;\n1;2;4")).isEqualTo(7);
        Assertions.assertThat(calculator.calc("///\n10/20/30")).isEqualTo(60);
    }

    @Test
    @DisplayName("커스텀 구분자 사용했을 때 다른 구분자가 있는 경우 예외 처리하기")
    void When_AnotherDelimitersUsed_Expect_ThrowException() {
        Assertions.assertThatThrownBy(() -> {
            calculator.calc("//;\n1,2,4");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수를 전달하는 경우 예외 처리")
    void When_NegativeNumbersGiven_Expect_ThrowRuntimeException() {
        Assertions.assertThatThrownBy(() -> {
            calculator.calc("//;\n-1;2;4");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("음수는 처리할 수 없습니다.");
    }

}
