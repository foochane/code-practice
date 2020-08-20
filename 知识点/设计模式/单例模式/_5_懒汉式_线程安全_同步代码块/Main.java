package 设计模式.单例模式._5_懒汉式_线程安全_同步代码块;


/**
 * 不推荐使用
 * 解决了 线程安全问题
 *
 * 效率太低了，每个线程在想获得类的实例时候，执行 getInstance()方法都要进行同步。而其实这个方法只执行
 * 一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。 方法进行同步效率太低
 *
 */
class Singleton{

    //1 构造器私有化，使外部不能new
    private Singleton(){};

    //2 本类创建对象实例
    private static Singleton instance;


    //3 提供一个公有方法，返回实例
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {

        int i = 10000;
        while (i-- > 0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton instance = Singleton.getInstance();
                    System.out.println("instance.hashCode=" + instance.hashCode());
                }
            }).start();

        }

    }
}
