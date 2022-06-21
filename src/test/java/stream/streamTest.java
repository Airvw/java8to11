package stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

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

//    @Test
//    @DisplayName("close 되지 않은 수업")
//
//    @Test
//    @DisplayName("수업 이름만 모아서 스트림 만들기")
//
//    @Test
//    @DisplayName("두 수업 목록에 들어있는 모든 수업 아이디 출력")
//
//    @Test
//    @DisplayName("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만")
//
//    @Test
//    @DisplayName("자바 수업 중에 Test가 들어있는 수업이 있는지 확인")
}
