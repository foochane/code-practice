package _13_调整数组顺序使奇数位于偶数前面;


import java.util.ArrayList;
import java.util.Arrays;
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
    // 用两个list存储奇数和偶数然后合并
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
    // 从左往右找array[i]为偶数的i，先让j=i，往右边继续找奇数，如果有奇数array[j]，j=奇数的下标，
    // array[i]与array[j]互换位置
    public void reOrderArray2(int [] array) {
        int i = 0;
        int j;
        int temp;
        while(i<array.length-1){

            if(array[i]%2 != 0){
                i++;
                continue;
            }
            j = i;
            for (int x = j+1; x < array.length; x++){
                if(array[x]%2 != 0){
                    j = x;
                    break;
                }
            }
            while (i<j){
                temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }

            i++;
        }
    }

    // 方法三
    // 从左往右找，遇到左边是偶数，右边是奇数，就把这两个数互换位置
    public void reOrderArray3(int [] array){
        int temp;
        int i = 0;
        while ( i < array.length -1) {
            if(array[i]%2 == 0 && array[i+1]%2 == 1){
                temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
                i = 0;
                continue;
            }
            i++;
        }

        System.out.println(Arrays.toString(array));
    }



}
