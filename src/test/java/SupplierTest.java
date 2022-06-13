import function.Supply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierTest {

    @Test
    @DisplayName("람다식 적용X")
    void supplier(){
        Supply get123 = new Supply();
        assertThat(get123.get()).isEqualTo(123);
    }

    @Test
    @DisplayName("람다식 적용")
    void supplierLambda(){
        Supplier<Integer> get123 = () -> 123;
        assertThat(get123.get()).isEqualTo(123);
    }
}
