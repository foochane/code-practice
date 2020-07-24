package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        /**
         * 通过反射获取对象有三种方法
         * 1.通过对象获取，首先该对象要已经新建
         * 2.通过Class.forName("相对路径")获取
         * 3.通过 类名.class 获取
         */
        //方法一：通过对象获取
        MyReflect myReflect = new MyReflect();
        Class class1 = myReflect.getClass();

        //方法二：通过Class.forName("相对路径") 获取
        //注意处理ClassNotFoundException
        Class class2 = Class.forName("反射.MyReflect");


        //方法三：通过类名获取
        Class class3 = MyReflect.class;

        /**
         * 通过反射调用方法
         * 1.通过 类.getMethod("方法“)获取方法method
         * 2.通过method.invoke()来调用方法
         * 3.invoke里面可以直接传class,也可以传新建的实例对象通过class.newInstance()
         * 4.如果调用的是私有方法需要设置 method.setAccessible(true)
         */
        //静态方法调用
        Method method1 = class3.getMethod("staticMd");
        method1.invoke(class3);

        //调用公共方法
        Object instance1 = class2.newInstance();
        Method method2 = class2.getMethod("publicMd");
        method2.invoke(instance1);

        //私有方法
        Object instance2 = class1.newInstance();
        Method method3 = class1.getMethod("staticMd");
        method3.setAccessible(true);
        method3.invoke(class1);

    }
}
