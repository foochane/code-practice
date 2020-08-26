package 多线程.volatile不能保证原则性;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile可以保证访问的可见性，防止指令重排，被它修饰的变量，一旦修改会立即更新到主存，其他线程能读取也会去主存中读取。
 * synchronized可以保证变量修改的可见性和原子性。
 * volatile不会造成线程的阻塞，synchronized会造成线程的阻塞。
 * volatile解决变量访问可见性问题，synchronized解决多线程访问可见性的问题。
 */
public class Main {
    private static volatile int count = 0;
    private static volatile int synCount = 0;
    private static final AtomicInteger atomicCount = new AtomicInteger(0);
    private static synchronized void add(){
        synCount++;
    }
    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    count++;
                    add();
                    atomicCount.getAndIncrement();
                }
            }).start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        System.out.println(synCount);
        System.out.println(atomicCount.get());
    }
}
