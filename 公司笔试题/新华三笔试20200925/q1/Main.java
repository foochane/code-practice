package 新华三笔试20200925.q1;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(character_auto_complete("Sxxx"));
    }

    public static String character_auto_complete (String str) {
        // write code here
        String[] dic = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        HashMap<String, String> map = new HashMap<String, String>();
        for (String s : dic) {
            for (int i = 1; i < s.length(); i++) {
                String sub = s.substring(0, i);
                map.put(sub, map.getOrDefault(sub, "") + " " + s);
            }
        }
        String ans = map.get(str);
        return ans == null ? "No match" : ans.trim();

    }
}
