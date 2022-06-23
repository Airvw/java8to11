package stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class streamTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private List<OnlineClass> springClasses;
    private List<OnlineClass> javaClasses;
    private List<List<OnlineClass>> airvwEvents;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
        springClasses = new ArrayList<>();
        javaClasses = new ArrayList<>();
        airvwEvents = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
        airvwEvents.add(springClasses);
        airvwEvents.add(javaClasses);
    }

    @Test
    @DisplayName("spring으로 시작하는 수업")
    void startSpring(){
        springClasses.stream().filter(sc -> sc.getTitle().startsWith("spring"))
                .forEach(sc -> System.out.println(sc.getTitle()));
        assertThat(byteArrayOutputStream.toString()).isEqualTo("spring boot\r\nspring data jpa\r\nspring mvc\r\nspring core\r\n");
    }

    @Test
    @DisplayName("close 되지 않은 수업")
    void notClosed(){
        springClasses.stream().filter(sc -> !sc.isClosed())
                .forEach(sc -> System.out.println(sc.getTitle()));
        assertThat(byteArrayOutputStream.toString()).isEqualTo("spring mvc\r\nspring core\r\nrest api development\r\n");
    }

    @Test
    @DisplayName("수업 이름만 모아서 스트림 만들기")
    void getTitles(){
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("spring boot\r\n" +
                "spring data jpa\r\n" +
                "spring mvc\r\n" +
                "spring core\r\n" +
                "rest api development\r\n");
    }

    @Test
    @DisplayName("두 수업 목록에 들어있는 모든 수업 아이디 출력")
    void classesTitles(){
        airvwEvents.stream().flatMap(Collection::stream)
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("spring boot\r\n" +
                "spring data jpa\r\n" +
                "spring mvc\r\n" +
                "spring core\r\n" +
                "rest api development\r\n" +
                "The Java, Test\r\n" +
                "The Java, Code manipulation\r\n" +
                "The Java, 8 to 11\r\n");
    }

    @Test
    @DisplayName("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만")
    void increaseStream(){
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::print);
        assertThat(byteArrayOutputStream.toString()).isEqualTo("20212223242526272829");
    }

    @Test
    @DisplayName("자바 수업 중에 Test가 들어있는 수업이 있는지 확인")
    void anyTest(){
        assertThat(javaClasses.stream().anyMatch(jc -> jc.getTitle().contains("Test"))).isTrue();
    }

    @Test
    @DisplayName("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기")
    void makeSpringList(){
        List<String> spirngLists = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(sc -> sc.contains("spring"))
                .collect(Collectors.toList());
        assertThat(spirngLists.size()).isEqualTo(4);
    }
}
