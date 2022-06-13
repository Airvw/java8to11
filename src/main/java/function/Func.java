package function;

import java.util.function.Function;

public class Func implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer num) {
        return num * 2;
    }
}
