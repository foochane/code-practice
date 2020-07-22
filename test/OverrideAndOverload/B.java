package OverrideAndOverload;

public class B extends A {

    //这是重写
    @Override
    public void method() {
        System.out.println("B");
    }

    //这还是是重写
    @Override
    public void method(int a) {
        System.out.println("B:" + a);
    }

    //这不是重载也不是重写？？？？
    public void method(int a, int b) {
        System.out.println("B," + a + b );
    }
}
