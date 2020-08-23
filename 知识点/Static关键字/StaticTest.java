package Static关键字;

/**
 * static 关键字
 * 静态方法/变量不属于任何实例对象，被所有实例对象共享，通过类名就可以调用
 * 静态变量jdk1.6存放在方法区（永久代），1.7以后放在堆区
 */

class Person{
    public static int id;
    protected int age ;
    Person(int id, int age){
        Person.id = id;
        this.age = age;
    }

}
public class StaticTest {

    public static void main(String[] args) {
        Person p1 = new Person(1,20);
        Person p2 = new Person(2,20);
        System.out.println(Person.id);
        System.out.println(Person.id);
        System.out.println(p1.age);

    }



}
