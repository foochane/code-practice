package 设计模式.单例模式._1_饿汉式_静态常量;

/**
 * 这种单例模式可用，但是可能造成内存浪费
 *
 * 步骤：
 * 1) 构造器私有化 (防止 new )
 * 2) 类的内部创建对象
 * 3) 向外暴露一个静态的公共方法, getInstance
 */
class Singleton{
    //1 构造器私有化 (防止 new )
    private Singleton(){};

    //2 类的内部创建对象
    private static final Singleton instance = new Singleton();

    //3 向外暴露一个静态的公共方法。getInstance
    public static Singleton getInstance() {
        return instance;
    }

}
public class Main {

    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
