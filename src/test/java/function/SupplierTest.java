package function;

import function.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierTest {

    private Supply supply;

    @BeforeEach
    void setUp(){
        supply = new Supply();
    }

    @Test
    @DisplayName("람다식 적용X")
    void supplier(){
        assertThat(supply.get()).isEqualTo(123);
    }

    @Test
    @DisplayName("람다식 적용")
    void supplierLambda(){
        Supplier<Integer> get123 = supply::get;
        assertThat(get123.get()).isEqualTo(123);
    }
}
