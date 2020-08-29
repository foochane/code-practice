package 静态代理和动态代理.静态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//1 定义一个接口
interface SellPerfume{
    void sellPerfume(double price);
}

//2 实现接口，工厂
class ChanelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("购买香奈儿香水，价格是：" + price + "元");
    }
}

class SellProxy implements InvocationHandler {
    /** 代理的真实对象 */
    private final Object realObject;


    public SellProxy(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object obj = method.invoke(realObject, args);
        doSomethingAfter();
        return obj;
    }

    private void doSomethingAfter() {
        System.out.println("执行代理后的额外操作...");
    }

    private void doSomethingBefore() {
        System.out.println("执行代理前的额外操作...");
    }
}
public class Main {
    public static void main(String[] args) {
        ChanelFactory chanelFactory = new ChanelFactory();
        SellProxy proxy = new SellProxy(chanelFactory);
        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(chanelFactory.getClass().getClassLoader(),
                chanelFactory.getClass().getInterfaces(),
                proxy);
        sellPerfume.sellPerfume(1000.0);
    }
}
