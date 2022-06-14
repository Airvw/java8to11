package function;

import java.util.function.Predicate;

public class Predic implements Predicate<Integer> {


    @Override
    public boolean test(Integer num) {
        if(num % 2 == 0){
            return true;
        }
        return false;
    }
}
