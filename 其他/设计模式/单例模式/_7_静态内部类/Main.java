package 设计模式.单例模式._7_静态内部类;

/**
 * 推荐使用
 *
 * 避免了线程不安全，利用 静态内部类特点实现延迟加载，效率高
 */

class Singleton {

    //1 构造器私有化
    private Singleton() {}

    //2 创建对象实例
    private static volatile Singleton instance;

    //写一个静态内部类,该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //3 提供公有方法返回实体
    //提供一个静态的公有方法，直接返回 SingletonInstance.INSTANCE
    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
public class Main {
}
