package 新浪笔试20200913.q2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : chars) {
//            if(map.containsKey(c)){
//                System.out.println(false);
//                break;
//            }else {
//                map.put(c, 1);
//            }
//        }

        System.out.println(set.size() == chars.length);
    }
}
