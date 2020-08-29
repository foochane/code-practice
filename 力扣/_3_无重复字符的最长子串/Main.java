package _3_无重复字符的最长子串;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring1(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int subStrLen = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                i = map.get(c);
                int size = map.size();
                if(size > subStrLen) subStrLen = size;
                map.clear();
            }else{
                map.put(c, i);
            }
            i++;
        }
        int size = map.size();
        if(size > subStrLen) subStrLen = size;
        return subStrLen;

    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        int start = 0;
        int end = start;
        int max = 0;
        while(end < len){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c) + 1,start);  //找距离end最近的start
            }
            map.put(c, end);
            max = Math.max(max, end -start + 1);
            end++;
        }

        return max;
    }




}
