package 排序.归并排序;

import java.util.Arrays;

public class MergeSort {

    //把长度为n的输入序列分成两个长度为n/2（n/2 -1）的子序列；
    //对这两个子序列分别采用归并排序；
    //将两个排序好的子序列合并成一个最终的排序序列。
    public static  void mergeSort(int[] arr, int left, int right){
        if(right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        //合并好的数组放回arr
        System.arraycopy(temp,0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8,9,10,32,2,81,99,12};

        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
