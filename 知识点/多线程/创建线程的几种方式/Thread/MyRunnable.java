package 多线程.创建线程的几种方式.Thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":run.......");
    }
}
