package _07_斐波那契数列;


/**
 *《剑指Offer_编程题-斐波那契数列》
 *
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 *
 * 20200323
 */
public class Solution {

    //斐波那契数列的的标准公式：
    // F(n) = 0, n=0
    // F(n) = 1, n=1,2
    // F(n) = F(n-1) + F(n-2), n>2

    // 方法一
    // 直接根据公式使用递归(不建议使用）
    public int Fibonacci1(int n) {
        if(n<2){
            return n;
        }
        return Fibonacci1(n-1) + Fibonacci1(n-2);
    }

    // 方法二
    // 使用3个变量
    public int Fibonacci2(int n){
        if(n<2){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    // 方法三
    // 使用2个变量
    public int Fibonacci3(int n){
        if(n<2){
            return n;
        }
        int a = 0;
        int b = 1;
        for(int i = 3; i<=n; i++){
            b = a+b;
            a = b-a;
        }
        return a+b;
    }

}
