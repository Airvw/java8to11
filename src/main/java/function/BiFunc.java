package function;

import java.util.function.BiFunction;

public class BiFunc implements BiFunction<String, String, String> {

    @Override
    public String apply(String hello, String name) {
        return hello + " " + name;
    }
}
