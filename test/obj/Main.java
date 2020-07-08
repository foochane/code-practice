package obj;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("aaa");
        Person p2 = p1;
        System.out.println(p1.getName()); // aaa
        System.out.println(p2.getName()); // aaa

        p2.setName("bbb");
        System.out.println(p1.getName()); //bbb
        System.out.println(p2.getName()); //bbb



        String s1 = "aaa";
        String s2 = s1;
        System.out.println(s1); // aaa
        System.out.println(s2); // aaa

        s2 = "bbb";
        System.out.println(s1); //aaa
        System.out.println(s2); //bbb
        int a = 1;
        int b = a;
        System.out.println(a); // 1
        System.out.println(b); // 1
        b = 2;
        System.out.println(a); // 1
        System.out.println(b); // 2


        int[] arr1 = {1,2};
        int[] arr2 = arr1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        arr2[0] = 2;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        char[] chars = {'a','b'};
        System.out.println(chars);



    }
}
