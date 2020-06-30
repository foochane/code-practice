package 查找数组中出现次数为奇数的数;
/**
 *
 * 题目1： 给定一个含有n个元素的整形数组，其中只有一个元素出现奇数次，找出这个元素
 *
 * 异或
 *
 * 题目2： 如果题目1中有两个数出现了奇数次，并且这两个数并不相等，如何在O(1)的复杂度内找出这两个数
 *
 * https://www.cnblogs.com/yxzfscg/p/4782078.html
 *
 * 20200630
 */

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String[] str = cin.nextLine().split(" ");
        int[] num = new int[str.length];

        for(int i = 0; i < str.length; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        
        int[] result = findNum(num);

        System.out.println(Arrays.toString(result));

    }

    // 假设这两个数为a和b
    // 使用异或 ^= ，之后得到 a^b = x
    // 从左边开始找x的二进制数组为1的位数k，说明在第k位的时候a和b有一个为1
    // 把数组中第k为为1的数全部找出来与x取异或 ^=, 假设数组第k为1的数异或后为T，则x^T=b（或者x^T=b）
    // 得到a就可以求得b ，b = x^a，反之亦然
    private static int[] findNum(int[] num) {

        int x = 0;
        int k = 0;

        // 求x
        for (int n : num) {
            x ^= n;
        }
        int xCopy = x;

        // 求k
        while ( (xCopy & 1) == 0){
            xCopy = xCopy >> 1;
            k++;
        }
        xCopy = x;

        // 求 a 和 b
        for (int m : num) {
            if(((m >> k) & 1) == 0){
                xCopy ^= m;
            }
        }

        return new int[]{xCopy,x^xCopy};
    }
}