package OverrideAndOverload;

public class A {
    public void method(){
        System.out.println("A");
    }

    // 这是重载
    public void method(int a){
        System.out.println("A:" + a);
    }
}
