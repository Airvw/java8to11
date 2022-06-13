import function.BiFunc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    private final String hello = "안녕";
    private final String name = "더 자바";

    @Test
    @DisplayName("람다식 적용X")
    void biFunction(){
        BiFunc biFunc = new BiFunc();
        assertThat(biFunc.apply(hello, name)).isEqualTo("안녕 더 자바");
    }

    @Test
    @DisplayName("람다식 적용")
    void biFunctionLambda(){
        BiFunction<String, String, String> biFunction = (s1, s2) -> s1 + " " + s2;
        assertThat(biFunction.apply(hello, name)).isEqualTo("안녕 더 자바");
    }
}
