package 多线程.多个线程及交替打印;


/**
 * 使用wait和notify实现
 * 这种方法可以创建多个线程
 */
public class UsingWaitAndNotify {

    private static Object obj = new Object();
    static class MyThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    try {
                        obj.notify();
                        System.out.println(Thread.currentThread().getName() + ":执行....");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    try {
                        obj.notify();
                        System.out.println(Thread.currentThread().getName() + ":执行....");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
//            MyRunnable r = new MyRunnable();
//            new Thread(r).start();
//        }
        for (int i = 0; i < 2; i++) {
            new Thread().start();
        }

    }
}
