package 多线程.多个线程及交替打印;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量
 */
public class UsingSemaphore {
    public static Semaphore s1 = new Semaphore(1);
    public static Semaphore s2 = new Semaphore(0);
    public static Semaphore s3 = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true){
                try {
                    s1.acquire();
                    System.out.println(Thread.currentThread().getName());
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true){
                try {
                    s2.acquire();
                    System.out.println(Thread.currentThread().getName());
                    s3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                try {
                    s3.acquire();
                    System.out.println(Thread.currentThread().getName());
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
