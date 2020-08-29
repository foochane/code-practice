package 静态代理和动态代理.动态代理.使用CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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

class SellProxyFactory implements MethodInterceptor {
    // 关联真实对象，控制对真实对象的访问
    private Object realObject;
    /** 从代理工厂中获取一个代理对象实例，等价于创建小红代理 */
    public Object getProxyInstance(Object realObject) {
        this.realObject = realObject;
        Enhancer enhancer = new Enhancer();
        // 设置需要增强类的类加载器
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        // 设置被代理类，真实对象
        enhancer.setSuperclass(realObject.getClass());
        // 设置方法拦截器，代理工厂
        enhancer.setCallback(this);
        // 创建代理类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        doSomethingBefore(); // 前置增强
        Object object = methodProxy.invokeSuper(o, objects);
        doSomethingAfter(); // 后置增强
        return object;
    }

    private void doSomethingBefore() {
        System.out.println("执行方法前额外的操作...");
    }

    private void doSomethingAfter() {
        System.out.println("执行方法后额外的操作...");
    }

}

public class Main {
    public static void main(String[] args) {
        SellProxyFactory sellProxyFactory = new SellProxyFactory();
        // 获取一个代理实例
        SellPerfume proxyInstance =
                (SellPerfume) sellProxyFactory.getProxyInstance(new ChanelFactory());
        // 创建代理类
        proxyInstance.sellPerfume(1999.99);
    }
}
