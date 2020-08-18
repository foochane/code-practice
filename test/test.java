import java.util.Arrays;

public class test {

    public static void main(String[] args){
        int[] arr = {3,34,9,2,39,1,90};
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end){
        System.out.println(Arrays.toString(arr));
        if(start >= end) return;
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex -1);
        quickSort(arr,pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotIndex = start;

        int pivotValue = arr[pivotIndex];
        System.out.println(pivotValue);

        //从两边
        while(start < end){

            while (start < end && arr[end] > pivotValue) end--;
            while (start < end && arr[start] <= pivotValue) start++;



            if(start < end){
                swap(arr, start, end);
            }
        }
        swap(arr, pivotIndex, start);

        return start;

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


