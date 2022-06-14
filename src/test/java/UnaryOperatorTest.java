import function.UnaryOper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class UnaryOperatorTest {

    private final int num  = 10;

    @Test
    @DisplayName("람다식 적용 X")
    void unaryOperator(){
        UnaryOper unaryOper = new UnaryOper();
        assertThat(unaryOper.apply(num)).isEqualTo(30);
    }

    @Test
    @DisplayName("람다식 적용")
    void unaryOpertorLambda() {
        UnaryOperator<Integer> unaryOperator = (i) -> i * 3;
    }
}
