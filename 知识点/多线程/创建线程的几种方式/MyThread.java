package 多线程.创建线程的几种方式;

public class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": run..........");
    }
}
