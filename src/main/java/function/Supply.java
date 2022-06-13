package function;

import java.util.function.Supplier;

public class Supply implements Supplier<Integer> {

    @Override
    public Integer get() {
        return 123;
    }
}
