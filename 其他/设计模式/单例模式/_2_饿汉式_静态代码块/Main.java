package 设计模式.单例模式._2_饿汉式_静态代码块;

/**
 * 这种单例模式可用，但是可能造成内存浪费
 */
class Singleton{
    //1 构造器私有化，使外部不能new
    private Singleton(){};

    //2 本类创建对象实例
    private static final Singleton instance;

    //在静态代码块中，创建单例实例
    static{
        instance = new Singleton();
    }

    //3 提供一个公有方法，返回实例
    public static Singleton getInstance(){
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
