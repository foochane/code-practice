package 广联达20200917.q2;

/**
 * 元素平衡
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 《XX魔法书》中记载，只有魔法师体内地火水风四种元素平衡的时候才是绝对安全的。某魔法师在给自己做了一个体检，发现自己体内的四种元素数量分别是A，B，C，D，魔法师慌了，这时他看到魔法书中记载了一种转换魔法，可以把任意两个单位的元素转换成任意一种元素。
 *
 * 请问魔法师是否可以通过这种魔法，在保证自己体内的元素总量尽可能多的情况下，使得自己体内的四种元素数量完全相同？如果可以，请输出平衡后体内元素总量，如果不能请输出-1。
 *
 *
 *
 * 输入描述
 * 输入仅包含一行，仅包含4个正整数A，B，C，D，分别表示四种元素的数量。(1<=A,B,C,D<=10^17)
 *
 * 输出描述
 * 输出仅包含一个整数,如题所示。
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        int ave = sum / 4;
        int x = 0, y = 0;
        for (int num : nums) {
            if(num < ave) {
                x++;
            }else {
                y += (num - ave);
            }
        }

        if(x >= (y / 2)){
            System.out.println(ave * 4);
        }else {
            System.out.println(nums[1] );
        }
    }
}
