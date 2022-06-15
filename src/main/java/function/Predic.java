package function;

import java.util.function.Predicate;

public class Predic implements Predicate<Integer> {


    @Override
    public boolean test(Integer num) {
        return num % 2 == 0;
    }
}
