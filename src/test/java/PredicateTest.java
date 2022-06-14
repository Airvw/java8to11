import function.Predic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateTest {

    private final int num = 44;

    @Test
    @DisplayName("람다식 적용X")
    void predicate(){
        Predic predic = new Predic();
        assertThat(predic.test(num)).isEqualTo(true);
    }

    @Test
    @DisplayName("람다식 적용")
    void predicateLambda(){
        Predicate<Integer> predicate = (i) -> i % 2 == 0;
        assertThat(predicate.test(num)).isEqualTo(true);
    }
}
