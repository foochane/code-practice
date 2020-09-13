package _360笔试20200912.q2;

/**
 * 判断密码必须包含数字、大写、小写、和字符，长度大于8
 */

import java.util.Scanner;

public class Main {
    //数字
    public static final String REG_NUMBER = ".*\\d+.*";
    //小写字母
    public static final String REG_UPPERCASE = ".*[A-Z]+.*";
    //大写字母
    public static final String REG_LOWERCASE = ".*[a-z]+.*";
    //特殊符号
    public static final String REG_SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();

            //密码为空或者长度小于8位则返回false
            if (s == null || s.length() <8 ){
                System.out.println("Irregular password");
                continue;
            }

            int i = 0;
            if (s.matches(REG_NUMBER)) i++;
            if (s.matches(REG_LOWERCASE))i++;
            if (s.matches(REG_UPPERCASE)) i++;
            if (s.matches(REG_SYMBOL)) i++;

            if (i  < 3 ) {
                System.out.println("Irregular password");
            }else {
                System.out.println("Ok");
            }
        }


    }
}