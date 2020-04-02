package _12_数值的整数次方;


/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 *
 * 20200324
 */
public class Solution {

    // 方法一
    // 使用java自带的库
    public double Power1(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    // 方法二
    // 转换为乘法
    public double Power2(double base, int exponent){
        //base和exponent不同时为0
        double result=1.0;
        if (base == 0){
            result = 0;
        }
        if (exponent == 0){
            result = 1;
        }

        if(exponent>0){
            for (int i = 0; i < exponent; i++) {
                result*=base;
            }
        }

        if (exponent<0){
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                result/=base;
            }
        }

        return result;
    }
}
