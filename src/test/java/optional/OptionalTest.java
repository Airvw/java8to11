package optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.OnlineClass;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OptionalTest {

    private List<OnlineClass> springClasses = new ArrayList<>();

    @BeforeEach
    void setUp(){
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));
    }

    @Test
    void isPresentTest() {

        Optional<OnlineClass> hiveClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("hive"))
                .findFirst();

        Optional<OnlineClass> springClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findAny();

        assertThat(hiveClass.isPresent()).isFalse();
        assertThat(springClass.isPresent()).isTrue();
    }

    @Test
    void getTest(){
        Optional<String> hadoopTitle = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(s -> s.startsWith("hadoop"))
                .findFirst();

        assertThatThrownBy(hadoopTitle::get).isInstanceOf(NoSuchElementException.class);
    }
}
