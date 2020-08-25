package 多线程.多个线程及交替打印;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量和一个flag标记
 * flag标记只有两种状态，所以就只能创建两个线程
 */
public class UsingSemaphore {
    //传入参数为1，表示同一时刻只能有一个线程运行
    public static Semaphore semaphore = new Semaphore(1);

    //注意要使用volatile关键字
    public static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true){
                if (flag){
                    try {
                        semaphore.acquire();
                        flag = !flag;
                        System.out.println(Thread.currentThread().getName());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                if (!flag){
                    try {
                        semaphore.acquire();
                        flag = !flag;
                        System.out.println(Thread.currentThread().getName());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
