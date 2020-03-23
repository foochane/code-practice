package _01_二维数组中的查找;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{2,5,6},
                {3,6,7},
                {4,7,9}};
        int[][] array1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 16;
        System.out.println(Solution.Find2(target,array1));
    }
}

