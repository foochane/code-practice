package 设计模式.单例模式._3_懒汉式_线程不安全;


/**
 * 不推荐使用
 *
 * 起到了 Lazy Loading 的效果，但是只能在单线程下使用。
 *
 * 如果在多线程下，一个线程进入了 if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过
 * 了这个判断语句，这时便会 产生多个实例。所以在多线程环境下不可使用这种方式

 */
class Singleton{

    //1 构造器私有化，使外部不能new
    private Singleton(){};

    //2 本类创建对象实例
    private static Singleton instance;


    //3 提供一个公有方法，返回实例
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
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
