import function.Func;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FuntionTest {

    private final int num = 10;

    @Test
    @DisplayName("람다식 적용 X")
    void funtion(){
        Func func = new Func();
        assertThat(func.apply(10)).isEqualTo(20);
    }

    @Test
    @DisplayName("람다식 적용 O")
    void functionLambda(){
        Function<Integer, Integer> func = (i) -> i * 2;
        assertThat(func.apply(num)).isEqualTo(20);
    }
}
