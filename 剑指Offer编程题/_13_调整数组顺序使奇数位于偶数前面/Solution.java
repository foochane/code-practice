package _13_调整数组顺序使奇数位于偶数前面;


import java.util.ArrayList;
import java.util.List;

/**
 *
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593
 *
 * 20200402
 */
public class Solution {

    // 方法一
    public void reOrderArray(int [] array) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(array[i]==0){
                continue;
            }
            if(array[i]%2 != 0){
                list1.add(array[i]);
            }else {
                list2.add(array[i]);
            }
        }
        list1.addAll(list2);

        for (int i = 0; i < list1.size(); i++) {
            array[i] = list1.get(i);
        }

    }

    // 方法二

}
