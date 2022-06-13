package function;

import java.util.function.Consumer;

public class Consum implements Consumer<Integer> {

    @Override
    public void accept(Integer num) {
        System.out.print("pow(" + num + ") " + "is " + num * num);
    }
}
