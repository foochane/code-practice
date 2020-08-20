package 设计模式.单例模式._6_双重检查;


/**
 * 推荐使用
 *
 * 线程安全； 延迟加载； 效率较高
 */
// 懒汉式(线程安全，同步方法)
class Singleton {

    //1 私有化构造函数
    private Singleton() {}

    //2 volatile 不能省略，volatile能阻止编译重排
    private static volatile Singleton instance;


    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    //同时保证了效率, 推荐使用
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class Main {
}
