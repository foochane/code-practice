package 排序.堆排序;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSort(int[] arr){
        //构建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.remove();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8,9,10,32,2,81,99,12};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
