package 哈罗20201105.q1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"],"32"
        String[] chars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String s = "99";
        System.out.println(nextValue(chars, s));
    }

    public static String nextValue (String[] chars, String currentValue) {
        // write code here
        StringBuilder ans = new StringBuilder();
        int n = chars.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(chars[i], i);
        }
        System.out.println(map.keySet().toString());
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < currentValue.length(); ) {
            int j = i + 1;
            while (!map.containsKey(currentValue.substring(i, j))) {
                j++;
            }

            list.addLast(currentValue.substring(i, j));
            i = j;
        }

        System.out.println(list.toString());

        //最后一位加1
        String last = list.getLast();
        list.set(list.size() - 1, chars[(map.get(last) + 1) % n]);

        int index = list.size() - 1;
        //从最后一位开始，如果为0就进位
        while(index > 0 && list.get(index).equals(chars[0])){
            index--;
            String temp = list.get(index);
            list.set(index, chars[(map.get(temp) + 1) % n]);
        }

        // 如果第一位为0，前面加1
        if(list.getFirst().equals(chars[0])){
            list.addFirst(chars[1]);
        }
        for (String s : list) {
            ans.append(s);
        }

        return ans.toString();
    }
}
