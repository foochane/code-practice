package _11_二进制中1的个数;


/**
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8
 *
 * 20200324
 */
public class Solution {

    // 正数用0表示，负数用1表示
    // 正数的原码、反码、补码相同
    // 负数的反码等于原码的符号位不变其他为取反，负数的补码等于原码的符号位不变其他为取反+1
    //注意Java中负数是用补码表示。
    // -1 ：11111111111111111111111111111111
    // -2 : 11111111111111111111111111111110


    // 方法一
    // 先转成二进制字符串，然后切分之后数“1”的个数
    public int NumberOf1(int n) {

        int result = 0;
        String str = Integer.toBinaryString(n);
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("1")){
                result++;
            }
        }
        return result;
    }



    // 方法二
    public int NumberOf2(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    // 方法三
    public int NumberOf3(int n){
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;

    }
}
