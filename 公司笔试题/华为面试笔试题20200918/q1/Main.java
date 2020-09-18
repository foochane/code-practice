package 华为面试笔试题20200918.q1;

/**
 * 判断子序列
 */
public class Main {
    public static void main(String[] args) {
        String s = "abce";
        String t = "ahbgdc";
        System.out.println(isSubSeq(s, t));

    }

    public  static boolean isSubSeq(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }

        return  i == n;
    }

}



