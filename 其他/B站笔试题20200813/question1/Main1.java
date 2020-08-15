package B站笔试题20200813.question1;

/**
 * 给出4个1—10的数字，通过加减乘除，得到数字24
 * 示例：
 * 输入 7,2，1,10
 * 输出 true
 * 说明：7*2+1*10
 */
public class Main1 {
    public static boolean ans = false;
    public static int count = 0;
    public static void main(String[] args) {
        recur(new int[]{7, 2, 1, 10}, 0,0, 0 + "");
        System.out.println(ans);
        System.out.println(count);
    }

    public static void recur(int[] nums, int p, double result, String str){


        if(p == nums.length) {
            count++;
            System.out.println(str  + "=" + result);
            if(result == 24) ans = true;
            return;
        }

        if(result < 24){
            recur(nums, p+1, result + nums[p],str + "+" + nums[p]);
            recur(nums, p+1, result * nums[p],str + "*" + nums[p]);
        }
        if(result > 24){
            recur(nums, p+1, result - nums[p],str + "-" + nums[p]);
            recur(nums, p+1, result / nums[p],str + "/" + nums[p]);
        }

    }
}
