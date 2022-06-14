import function.BinaryOper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperatorTest {

    private final int num1 = 10;
    private final int num2 = 50;

    @Test
    @DisplayName("람다식 적용 X")
    void binaryOpertor(){
        BinaryOper binaryOper = new BinaryOper();
        assertThat(binaryOper.apply(num1, num2)).isEqualTo(40);
    }

    @Test
    @DisplayName("람다식 적용")
    void binaryOpertorLambda(){
        BinaryOperator<Integer> binaryOperator = (i, j) -> j - i;
        assertThat(binaryOperator.apply(num1, num2)).isEqualTo(40);
    }
}
