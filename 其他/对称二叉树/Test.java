package 对称二叉树;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();


        list.add(1);
        list.add(1);
        list.add(null);
        list.add(null);
        list.add(2);

        queue.add(1);
        queue.add(1);
        queue.add(null);
        queue.add(null);
        queue.add(2);

        set.add(1);
        set.add(1);
        set.add(null);
        set.add(null);
        set.add(2);


        System.out.println(list.toString());
        System.out.println(queue.toString());
        System.out.println(set.toString());


    }
}
