package 拼多多20200926.q2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < K; i++) {
            String[] s = sc.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[] nums = new int[n]; //能力
            String[] s1 = sc.nextLine().split(" ");
            for (int ii = 0; ii < s1.length; ii++) {
                nums[ii] = Integer.parseInt(s1[ii]);
            }

            for (int j = 0; j < n - 1; j++) {
                sc.nextLine();
            }


            Arrays.sort(nums);
            //System.out.println(Arrays.toString(nums));
            int ans = 0;
            for (int x = 0; x < k; x++) {
                ans += nums[n - 1 - x];
            }
            System.out.println(ans);
        }

    }


}
