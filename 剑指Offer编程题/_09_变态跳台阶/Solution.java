package _09_变态跳台阶;


/**
 *《剑指Offer_编程题-变态跳台阶》
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
 *
 * 20200323
 */
public class Solution {


    // 方法一
    // 根据题目得递推公式：
    // F(n) = 1, n=0
    // F(n) = F(n-1) + F(n-2) + ... + F(2） + F(1) + F(0), n>0
    public int JumpFloorII1(int target) {
        int n = 1;

        while (target>1){
            n += JumpFloorII1(--target);
        }
        return n;
    }

    // 方法二
    // F(n) = F(n-1) + F(n-2) + ... + F(2） + F(1) + F(0)
    // F(n-1) = F(n-2) + F(n-3) + ... + F(2） + F(1) + F(0)
    // 两式子相减得：F(n) = 2F(n-1)
    // 所以, F(n）= 2^(n-1)
    public int JumpFloorII2(int target) {
        return 1<<(target-1);
        //return (int)Math.pow(2,target-1);
    }
}
