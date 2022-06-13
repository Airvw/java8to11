import function.Consum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerTest {

    private int num = 9;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("람다식 적용X")
    void consumer(){
        Consum consum = new Consum();
        consum.accept(num);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("pow(9) is 81");
    }
}
