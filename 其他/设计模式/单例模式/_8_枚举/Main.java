package 设计模式.单例模式._8_枚举;

/**
 * 推荐使用
 *
 * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建
 * 新的对象
 */
enum Singleton{
    INSTANCE;
    public void test(){
        System.out.println("单例");
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        singleton1.test();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
