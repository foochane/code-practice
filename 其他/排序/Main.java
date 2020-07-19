package 排序;


import java.util.Arrays;

public class Main {
    //参考
    //https://www.cnblogs.com/guoyaohua/p/8600214.html
    //https://www.runoob.com/w3cnote/quick-sort-2.html
    //https://mp.weixin.qq.com/s?subscene=23&__biz=MzIxMjE5MTE1Nw==&mid=2653200809&idx=1&sn=44ed67f5382b0aea78867b41e92bf3e3&chksm=8c99d373bbee5a653932f01581a8cacbbeaf565b71b7df4698af43d5eabc75e3443d3c80e0ed&scene=7&key=30d2bdb92208469284847777f6a457f74b4c95bbf64fd115e624d086a0c0f2b8f5167cf73dbaba28135f197af87f7a81d6196919fcee8344837a763a40c074700e2c0d7038c854f909b44583f91bac15&ascene=0&uin=MTAzNTQ4NTcwMQ%3D%3D&devicetype=Windows+10+x64&version=62090529&lang=zh_CN&exportkey=AUeEUiq4JBLGecpY0v1sN1o%3D&pass_ticket=DhslL4UPb8CRHITXTHfU95ie11JZGSkZwum4z0YSYrFuYUmsmDZ6qNC7vgW89Y3R

    public static void main(String[] args) {
        int[] arr = {3,5,1,4,8,9,10,32,2,81,99,12};
//        int[] arr = {1,2,3,4,5,6,7,8,10,9};

        System.out.println(Arrays.toString(arr));
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

//        System.out.println(Arrays.toString(ShellSort1(arr)));
    }

    // 冒泡排序
    // 从第一个数开始，比较后面的数是否大于它，大于就把大往后移动
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    // 冒泡排序优化1
    // 如 1,2,3,4,5,6,7,8,10,9交换了10和9以后就不用再重复遍历前面已经排好序的数字
    public static void bubbleSort1(int[] arr){
        int len = arr.length;

        for(int i = 0; i < len -1; i++){
            boolean isSorted = false; // 设置标记，如果没有进行交换就直接跳出
            for(int j = 0; j < len - 1 -i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j +1);
                    isSorted = true;
                }
            }
            if(!isSorted) return;
        }
    }

    // 冒泡排序优化，鸡尾酒排序

    // 选择排序
    // 学生排队：从第一个开始找最矮的学生，找到后和第一个位置的学生交换位置，
    //         然后从第二个位置的学校开始，同样找最矮的学生，找到后和第二个位置的学士互换位置
    //         这样一直重复这个过程，直到最后一个学生。
    // 问题：存在不稳定性
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            int index = i;
            for(int j = i; j < len; j++){
                if(arr[index] > arr[j]) index = j;
            }
            if(i != index) swap(arr, i, index);
        }
    }

    // 选择排序优化
    // 查找最小值的同时把最大值也找查找出来
    public static  void selectionSort1(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int minIndex = left;
            int maxIndex = right;
            for(int i = left; i <= right; i++){
                if(arr[minIndex] > arr[i]) minIndex = i;
                if(arr[maxIndex] < arr[i]) maxIndex = i;
            }
            if(minIndex != left) swap(arr, minIndex, left);
            if(maxIndex != right) swap(arr, maxIndex, right);
            left++;
            right--;
        }
    }

    // 插入排序
    // 洗牌： 维护一个有序的区间，将区间后面的牌有序的插入到这个区间
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public static void insertionSort(int[] arr){
        int len = arr.length;
        // 一开始区间就只有第一个数
        for(int i = 1; i < len; i++){
            int insertValue = arr[i]; // 保存当前要插入的值
            int j = i-1; // 有序区间为[0,j],从j开始从右向左比较
            while (j >= 0 && arr[j] > insertValue){
                arr[j+1] = arr[j];
                j--;
            }
            // 有序区间空出来的位置插入insertValue
            arr[j+1] = insertValue;
        }
    }

    // 希尔排序
    // 希尔排序是插入排序的优化
    public static void shellSort(int[] arr){
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int insertValue = arr[i]; // 保存当前要插入的值
                int j = i - gap;
                while (j >= 0 && arr[j] > insertValue) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = insertValue;
            }
            gap /= 2;
        }
    }

//    冒泡排序和插入排序是稳定排序，值相同的元素在排序后仍然保持原本的先后顺序。
//    选择排序是不稳定排序，值相同的元素在排序后不一定保持原本的先后顺序。

    // 快速排序
    // 使用分治的思想，找一个基准pivot，比基准小的放在基准左边，比基准大的放在基准右边
    // 选数组第一个数据为基准
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr,left,pivotIndex - 1);
        quickSort(arr,pivotIndex + 1, right);
    }
    private static int partition(int[] arr, int left, int right) {
        // left 必须小于 right
        if(left > right) return -1;

        // 取第一个数为基准
        int pivotIndex = left;
        int pivot = arr[pivotIndex];

        while (left < right){
            // 循环里面的left< right条件必须加上！！！

            // 从右边开始查找，如果大于基准就继续，否则就停止
            while(left < right && arr[right] > pivot){
                right--;
            }
            // 从右边开始查找，如果小于等于基准就继续，否则停止
            while(left < right && arr[left] <= pivot){
                left++;
            }

            // 交换
            if(left < right){
                swap(arr, left, right);
            }
        }

        swap(arr, pivotIndex, left );

        // 返回下一次的基准下标
        return left;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
