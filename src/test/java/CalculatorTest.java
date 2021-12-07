import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    private class Calculator {

        private String delimiter = "[,:]";
        private String value = "";

        public int calc(String input) {
            int answer = 0;
            if (input == null || "".equals(input)) return answer;
            //TODO 구분자 구하기
            String patternString = "^//.\n";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                delimiter = Arrays.stream(input.split("^//|\n")).filter(s -> !"".equals(s)).findFirst().orElse(delimiter);
                value = pattern.splitAsStream(input).filter(s -> !"".equals(s)).collect(Collectors.joining());
                String[] arrays = value.split(delimiter);
                for (String s : arrays) {
                    answer+=Integer.parseInt(s);
                }
                return answer;
            }
            //TODO 구분자에 따라 나누기
            String[] arrays = input.split(delimiter);
            for (String s : arrays) {
                answer+=Integer.parseInt(s);
            }
            return answer;
        }
    }
}
