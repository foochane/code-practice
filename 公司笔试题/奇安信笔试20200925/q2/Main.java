package 奇安信笔试20200925.q2;

import java.util.Arrays;

/**
 * 零件加工
 */

public class Main {
    public static void main(String[] args) {
        int[] tasks = {1, 1, 1, 2, 3, 3, 3};
        int n = 2;
        System.out.println(leastWorkTime(tasks, n));
    }

    public static int leastWorkTime (int[] tasks, int n) {
        // write code here
        int ans = 0;
        int[] count = new int[10];
        int total = 0;

        for (int t : tasks) {
            count[t] ++;
            total++;
        }

        Arrays.sort(count);
        //System.out.println(Arrays.toString(count));
        int[] nums = new int[10];
        int i = count.length - 1;
        while(total > 0){

            if(count[i] > 0){
                if(nums[i] > 0 ){
                    if(count[i] > 0 && count[i - 1] <= 0){
                        ans += n;
                        nums[i] -= n;
                        continue;
                    }

                }else {
                    total--;
                    ans ++;
                    count[i]--;
                    nums[i] += n;
                    for (int j = i + 1; j < count.length; j++) {
                        if(nums[j] > 0 ) nums[j]--;
                    }
                }
            }

//            System.out.println(Arrays.toString(count));
//            System.out.println(Arrays.toString(nums));
//            System.out.println();
            i = i == 0 ? count.length - 1 : i - 1;

        }

        return ans;
    }

}
