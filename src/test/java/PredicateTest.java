import function.Predic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateTest {

    private final int num = 44;
    private Predic predic;

    @BeforeEach
    void setUp(){
        predic = new Predic();
    }

    @Test
    @DisplayName("람다식 적용X")
    void predicate(){
        assertThat(predic.test(num)).isEqualTo(true);
    }

    @Test
    @DisplayName("람다식 적용")
    void predicateLambda(){
        Predicate<Integer> predicate = predic::test;
        assertThat(predicate.test(num)).isEqualTo(true);
    }
}
