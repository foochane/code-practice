package 多线程.创建线程的几种方式.Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Integer call()  {
        System.out.println(Thread.currentThread().getName() + ": run .........");
        return 1;
    }
}
