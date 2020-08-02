package 数组按正负排列;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * 输入一个数组按正负正负排列，不改变正负数之间的相对位置
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        if(n <= 0) return;
        LinkedList<Integer> list = new LinkedList();
        int[] nums = new int[n];

        nums[0] = sc.nextInt();

        int k = 1;
        for (int i = 1; i < n; i++) {
            boolean ifPositive = nums[k - 1] > 0;
            int num = sc.nextInt();
            if(num > 0 == ifPositive && !list.isEmpty()){
                nums[k++] = list.pollFirst();
                continue;
            }else {
                nums[k++] = sc.nextInt();
            }
        }
    }
}
