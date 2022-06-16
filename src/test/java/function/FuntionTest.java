package function;

import function.Func;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FuntionTest {

    private final int num = 10;
    private Func func;

    @BeforeEach
    void setUp(){
        func = new Func();
    }

    @Test
    @DisplayName("람다식 적용 X")
    void funtion(){
        assertThat(func.apply(10)).isEqualTo(20);
    }

    @Test
    @DisplayName("람다식 적용")
    void functionLambda(){
        Function<Integer, Integer> function = func::apply;
        assertThat(function.apply(num)).isEqualTo(20);
    }
}
