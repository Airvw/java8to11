package defaultmethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IterableTest {

    private PrintStream printStream = System.out;
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void forEachTest(){
        List<String> names = Arrays.asList("a", "b", "c");
        names.forEach(System.out::print);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("abc");
    }

//    @Test
//    void spliteratorTest(){
//        List<String> names = Arrays.asList("hi", "hi airvw", "Bye");
//        Spliterator<String> spliter = names.spliterator();
//
//    }
}
