package function;

import java.util.function.UnaryOperator;

public class UnaryOper implements UnaryOperator<Integer> {
    @Override
    public Integer apply(Integer num) {
        return num * 3;
    }
}
