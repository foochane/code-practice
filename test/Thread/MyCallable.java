package Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Integer call()  {
        System.out.println(Thread.currentThread().getName() + ": run .........");
        return 1;
    }
}
