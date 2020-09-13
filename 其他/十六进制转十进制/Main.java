package 十六进制转十进制;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next().substring(2);
            char[] chars = s.toCharArray();
            int ans = 0;
            for(int i = chars.length - 1; i >= 0; i--){
                int num = 0;
                if(chars[i] >= '0' && chars[i] <= '9'){
                    num = chars[i] - '0';
                }else if(chars[i] >= 'A' && chars[i] <= 'F'){
                    num = chars[i] - 'A' + 10;
                }
                ans += Math.pow(16,(chars.length - 1 - i)) * num;
            }
            System.out.println(ans);
        }
    }
}