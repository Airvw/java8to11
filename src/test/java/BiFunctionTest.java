import function.BiFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionTest {

    private final String hello = "안녕";
    private final String name = "더 자바";
    private BiFunc biFunc;

    @BeforeEach
    void setUp(){
        biFunc = new BiFunc();
    }

    @Test
    @DisplayName("람다식 적용X")
    void biFunction(){
        assertThat(biFunc.apply(hello, name)).isEqualTo("안녕 더 자바");
    }

    @Test
    @DisplayName("람다식 적용")
    void biFunctionLambda(){
        BiFunction<String, String, String> biFunction = biFunc::apply;
        assertThat(biFunction.apply(hello, name)).isEqualTo("안녕 더 자바");
    }
}
