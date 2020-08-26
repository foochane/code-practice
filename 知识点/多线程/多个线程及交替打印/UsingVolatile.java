package 多线程.多个线程及交替打印;

public class UsingVolatile {
    private static volatile int flag = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(flag % 2 == 0){
                        System.out.println(Thread.currentThread().getName());
                        flag++;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(flag % 2 != 0){
                        System.out.println(Thread.currentThread().getName());
                        flag++;
                    }
                }
            }
        }).start();
    }
}
