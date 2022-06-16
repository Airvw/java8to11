package methodreference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingTest {

    private Greeting greeting;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final String name = "Airvw";

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("메소드 래퍼런스 생성자 테스트 인자X")
    void constructorTest(){
        Supplier<Greeting> supplier = Greeting::new;
        greeting = supplier.get();
        assertThat(greeting.getName()).isEqualTo("");
        greeting.sayHi();
        assertThat(byteArrayOutputStream.toString()).isEqualTo("Hi ");
    }

    @Test
    @DisplayName("메소드 래퍼런스 생성자 테스트 인자O")
    void constructorParamTest() {
        Function<String, Greeting> function = Greeting::new;
        greeting = function.apply(name);
        assertThat(greeting.getName()).isEqualTo("Airvw");
        greeting.sayHi();
        assertThat(byteArrayOutputStream.toString()).isEqualTo("Hi Airvw");
    }

    @Test
    @DisplayName("메소드 레퍼런스 스태틱 메소드 테스트")
    void staticMethodTest(){
        Consumer<String> consumer = Greeting::sayName;
        consumer.accept(name);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("Airvw!!");
    }

    @Test
    @DisplayName("메소드 레퍼런스 임의 객체의 메소드 테스트")
    void instanceMethodTest(){
        Function<String, Greeting> function = Greeting::new;
        List<String> list = new ArrayList<>();
        greeting = function.apply(name);
        list.add(greeting.getName());
        Supplier<Greeting> supplier = Greeting::new;
        greeting = supplier.get();
        list.add(greeting.getName());
        list.sort(String::compareToIgnoreCase);
        assertThat(list.toString()).isEqualTo("[, Airvw]");
    }
}
