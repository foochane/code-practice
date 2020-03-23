package _06_旋转数组的最小数字;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {5,6,7,7,9,1,3,4};
        System.out.println(s.minNumberInRotateArray2(array));

        int[] array1 = {1,0,1,1,1,1};
        System.out.println(s.minNumberInRotateArray2(array1));


    }
}
