package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Number;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void numberTest() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);
        assertThat(number1).isEqualTo(number2);
    }

    @Test
    void checkBiggerThanZeroCheck() {
        assertThatThrownBy(() -> {
            Number number = new Number(-10);
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("0보다 작은 값이 존재합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어올 때 RuntimeException 발생")
    void checkNumeric() {
        assertThatThrownBy(() -> {
            Number number = new Number("1*");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자로 바뀔 수 없습니다.");
    }
}