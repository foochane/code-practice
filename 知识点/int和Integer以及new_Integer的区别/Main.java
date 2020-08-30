package int和Integer以及new_Integer的区别;

/**
 * Integer a = new Integer(100); -->使用了new关键字，会在堆中创建对象
 * Integer b = 100;
 * Integer c = 128; --> 这里b和c是不同的，java会对 -128 ~ 127 直接的数进行缓存
 *                      对于b直接去的是缓存里的值，调用的 Integer.valueOf(100),不会再堆中创建对象
 *                      对于c会在堆中创建对象，new一个Integer对象
 *
 * Integer的自动拆箱：当Integer变量和int变量进行比较是，Integer变量会自动拆箱为int，所以比较的是具体的数值
 */
public class Main {
    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = 100;
        Integer d = 100;
        int e = 100;
        int f = 100;
        Integer h = new Integer(128);
        Integer i = new Integer(128);
        Integer j = 128;
        Integer k = 128;
        int l = 128;
        int m = 128;

        System.out.println(a == b);//false  new的对象放在堆中，比较的是地址值
        System.out.println(c == d);//true   没有创建对象
        System.out.println(e == f);//true 值的比较
        System.out.println(a == c);//false a有在堆中新建对象，c没有在堆中新建对象，比较的是地址值
        System.out.println(a == e);//true Integer自动拆箱
        System.out.println(c == e);//true Integer自动拆箱

        System.out.println(h == i); // false 比较的地址值
        System.out.println(j == k); // false 大于127 有创建对象
        System.out.println(l == m); // true 值的比较
        System.out.println(h == j); // false 比较的是地址值
        System.out.println(h == l); // true Integer自动拆箱
        System.out.println(j == l); // true Integer自动拆箱






    }
}
