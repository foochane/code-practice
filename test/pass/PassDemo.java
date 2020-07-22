package pass;


import java.util.Arrays;


/**
 * 验证java是值传递还引用传递
 * https://foochane.cn/article/2020072101.html
 */
public class PassDemo {
    public static void main(String[] args) {
        int a = 1;
        String str = "main";
        int[] arr = {1,2,3};
        Person person = new Person("小王",20);

        pass(a,str,arr,person);

        System.out.println("a=" + a); // a=1
        System.out.println("str=" + str); // str=main
        System.out.println("arr = " + Arrays.toString(arr)); // arr = [-1, 2, 3]
        System.out.println(person); // Person{name='老王', age=60}

    }

    private static void pass(int a, String str, int[] arr, Person person) {
        a = 2; // 没有改变main函数中a的值
        str = "pass"; // 没有改变main函数中str的值
        arr[0] = -1; // 将main函数中arr={1,2,3}改成了arr={-1,2,3}

        // 将main函数中Person{name='小王', age=20}改成了Person{name='老王', age=60}
        person.setName("老王");
        person.setAge(60);
    }

}

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
