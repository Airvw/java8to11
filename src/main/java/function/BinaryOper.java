package function;

import java.util.function.BinaryOperator;

public class BinaryOper implements BinaryOperator<Integer> {

    @Override
    public Integer apply(Integer num1, Integer num2) {
        return num2 - num1;
    }
}
