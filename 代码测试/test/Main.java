package test;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', map.getOrDefault('c', 0) + 1);
        System.out.println(map);

        LinkedList<Character> temp = new LinkedList<>();
//        temp.add('2');
//        temp.add('c');
//        temp.remove((Object)'2');
//        temp.remove('c');
        map.remove('c');
//
        Map<Character, Integer> map1 = new HashMap<>(map);
        System.out.println(map1);
    }

}
