package 排序.快速排序;

import java.util.Arrays;

public class QuickSort {


    //快速排序
    //使用分治的思想，找一个基准pivot，比基准小的放在基准左边，比基准大的放在基准右边
    //然后递归的对左右两边进行相同的操作
    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr,left,pivot - 1);
        quickSort(arr,pivot + 1, right);
    }
    private static int partition(int[] arr, int left, int right) {
        int nextPivot = left;
        for(int i = left; i <= right; i++){
            //选右边的数为基准pivot
            if(arr[i] < arr[right]){
                int temp = arr[i]; arr[i] = arr[nextPivot]; arr[nextPivot] = temp;
                nextPivot++;
            }
        }
        int temp = arr[right]; arr[right] = arr[nextPivot]; arr[nextPivot] = temp;
        return nextPivot;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8,9,10,32,2,81,99,12};

        System.out.println(Arrays.toString(arr));
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
