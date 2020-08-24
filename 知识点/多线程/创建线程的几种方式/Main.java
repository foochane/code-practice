package 多线程.创建线程的几种方式;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {



        //1 通过继承Thread类创建线程
        MyThread thread1 = new MyThread();
        thread1.start();

        //2 通过实现Runnable接口创建线程
        MyRunnable runnable = new MyRunnable();
        Thread  thread2 = new Thread(runnable);
        thread2.start();

        //3 通过实现Callable接口创建线程
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        Thread thread3 = new Thread(futureTask);
        thread3.start();

        Thread.sleep(100);
        System.out.println("返回结果：" + futureTask.get());


        //使用匿名内部类
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "：匿名内部类1");
            }
        }.start();

        //λ表达式
        new Thread(()-> System.out.println(Thread.currentThread() + "：匿名内部类2"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "匿名内部类3");
            }
        }).start();
    }
}
