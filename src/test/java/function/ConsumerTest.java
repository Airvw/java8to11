package function;

import function.Consum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerTest {

    private int num = 9;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private Consum consum;

    @BeforeEach
    void setUp(){
        consum = new Consum();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("람다식 적용X")
    void consumer(){
        consum.accept(num);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("pow(9) is 81");
    }

    @Test
    @DisplayName("람다식 적용")
    void consumerLambda(){
        Consumer<Integer> consumer = consum::accept;
        consumer.accept(num);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("pow(9) is 81");
    }
}
