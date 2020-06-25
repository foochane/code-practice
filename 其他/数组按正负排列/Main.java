package 数组按正负排列;

import java.util.Arrays;

/**
 * 输入一个数组按正负正负排列
 */
public class Main {
    public static void main(String[] args) {
        int[] num = {-1,2,-2,-3,4,5,7};
        getSort1(num);
        System.out.println(Arrays.toString(num));
    }

    private static void getSort(int[] num) {
        int len = num.length;
        int front = 0, rear = 0;
        while(rear < len - 1 && front < len - 1){
            rear = front + 1;
            if(front % 2 == 0){
                if(num[front] < 0){
                    while(num[rear] < 0) rear++;
                    swap(num, front, rear);
                }
            }else {
                if(num[front] > 0){
                    while(num[rear] < 0) rear++;
                    swap(num, front, rear);
                }
            }
            front++;
        }
    }

    private static void getSort1(int[] num){

        int len = num.length;
        int index = 0;
        while (index < len -1){

            if(num[index] < 0){
                int temp = find(index,num,true);
                swap(num,index,temp);
            }

            if(num[index + 1] > 0){
                int temp = find(index,num,false);
                swap(num,index,temp);
            }
            index +=2;
        }
    }

    private static int find(int index, int[] num, boolean flag) {

        for (int i = index + 1; i < num.length; i++) {
            if(flag){
                if(num[i] > 0) return i;
            }else {
                if(num[i] < 0) return i;
            }
        }
        return -1;
    }

    public static void swap(int[] num, int left, int right){
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }
}
