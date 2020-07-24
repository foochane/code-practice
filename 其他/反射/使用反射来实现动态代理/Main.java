package 反射.使用反射来实现动态代理;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Animal{
    void eat();
}
class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("dog is eating");
    }
}

class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("cat is eating");
    }
}

// 代理类
class AnimalProxy implements InvocationHandler{
    private Object target; //代理对象

    public Object getInstance(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用前");
        Object result = method.invoke(target, args);
        System.out.println("调用后");
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        AnimalProxy proxy = new AnimalProxy();
        Animal dogProxy = (Animal)proxy.getInstance(new Dog());
        dogProxy.eat();
        Animal catProxy = (Animal)proxy.getInstance(new Cat());
        catProxy.eat();
    }

}
