package _10_矩形覆盖;


/**
 *《剑指Offer_编程题-矩形覆盖》
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 *
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6
 *
 * 20200323
 */
public class Solution {

    //另一种形式的斐波那契数列
    // 跟08跳台阶那个题是一样的解法
    // F(n) = 1, n=1
    // F(n) = 2, n=2
    // F(n) = F(n-1) + F(n-2) ,n>2
    public int RectCover(int target) {
        if(target<=2){
            return target;
        }
        int a = 1;
        int b = 2;
        for(int i = 4; i<=target; i++ ){
            b = a+b;
            a = b-a;
        }

        return a+b;
    }
}
