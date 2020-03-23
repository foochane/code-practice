package _06_旋转数组的最小数字;


/**
 *《剑指Offer_编程题-旋转数组的最小数字》
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 *
 * 20200323
 */
public class Solution {

    // 方法一
    // 遍历数字，直接找最小值
    public int minNumberInRotateArray1(int [] array) {

        if(array.length==0){
            return 0;
        }

        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if(temp>array[i]){
                temp = array[i];
            }
        }
        return temp;
    }


    // 方法二
    // 从两端开始查找
    public int minNumberInRotateArray2(int [] array) {

        if(array.length==0){
            return 0;
        }

        int a = 0;
        int b = array.length -1;
        while (a<=b){
            if(array[a]<=array[a+1]){
                a++;
            }else {
                return array[a+1];
            }
            if(array[b]>=array[b-1]){
                b--;
            }else {
                return array[b];
            }
        }

        return array[a];
    }


    // 方法三
    // 二分法
    public int minNumberInRotateArray3(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] < array[j]) {
                return array[i];
            }
            int mid = (i + j) >> 1;
            if (array[mid] > array[i]) {
                i = mid + 1;
            } else if (array[mid] < array[j]) {
                j = mid; // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
            } else i++;  // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
        }
        return array[i];
    }
}
