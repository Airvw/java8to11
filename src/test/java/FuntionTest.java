import function.Func;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FuntionTest {

    @Test
    @DisplayName("람다식 적용 X")
    void funtion(){
        int num = 10;
        Func func = new Func();
        assertThat(func.apply(10)).isEqualTo(20);
    }
}
