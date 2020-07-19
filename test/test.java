import java.util.Arrays;

import static 数组按正负排列.Main.swap;

public class test {


    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 8, 6, 9};
        quickSort(arr, 0 ,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j , j+1);
                }
            }
        }
    }

    // 冒泡排序优化
    public static void bubbleSort1(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            boolean isSorted = false;
            for(int j = 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j , j+1);
                    isSorted = true;
                }
            }

            if(!isSorted) return;
        }
    }

    // 选择排序
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            int index = i;
            for(int j = i + 1; j < len; j++){
                if(arr[index] > arr[j]) index = j;
            }
            if(index != i) swap(arr, index ,i);
        }
    }

    public static void selectionSort1(int[] arr){
        int len = arr.length;
        int left = 0;
        int right = len -1;
        while (left < right){
            int minIndex = left;
            int maxIndex = right;
            for(int i = left; i <=right; i++){
                if(arr[minIndex] > arr[i]) minIndex = i;
                if(arr[maxIndex] < arr[i]) maxIndex = i;
            }
            if(minIndex != left) swap(arr,left,minIndex);
            if(maxIndex != right) swap(arr,right,maxIndex);
            left++;
            right--;
        }
    }

    // 插入排序
    public static void insertSort(int[] arr){
        int len = arr.length;
        for(int i = 1; i < len; i++){
            int insertValue = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > insertValue){
                arr[j+1] = arr[j];
                j--;
            }
            if(j + 1 != i) arr[j+1] = insertValue;
        }
    }


    // 快速排序
    // 分治思想
    // 选最左边的数据基准pivot，大于基准移到右边，小于基准移到左边
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot -1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right){
        if(left > right ) return  -1;

        int pivotIndex = left;
        int pivot = arr[left];
        while (left != right){
            while (left < right && arr[right] > pivot){
                right--;
            }

            while (left < right && arr[left] <= pivot){
                left++;
            }

            if(left < right){
                swap(arr, left, right);
            }
        }

        swap(arr, pivotIndex, left);

        return left;
    }

}

