package _08_跳台阶;


/**
 *《剑指Offer_编程题-跳台阶》
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 *
 * 20200323
 */
public class Solution {

    //另一种形式的斐波那契数列
    // F(n) = 0, n=0
    // F(n) = 1, n=1
    // F(n) = 2, n=2
    // F(n) = F(n-1) + F(n-2) ,n>2

    public int JumpFloor(int target) {
        if(target<=2){
            return target;
        }
        int a = 1;
        int b = 2;

        for (int i = 4; i <= target; i++) {
            b = a+b;
            a = b-a;
        }
        return a+b;
    }

}
