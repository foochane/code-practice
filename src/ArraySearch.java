/**
 * 《剑指Offer_编程题-二维数组中的查找》
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 *
 * 20200303
 */

public class ArraySearch {

    //暴力查找
    public boolean Find1(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    //从最左下角开始查找
    //每一行，左边的小于右边的
    //每一列，上边的小于下边的
    public static boolean Find2(int target, int [][] array) {
        int m = array.length; //行数
        int n = array[0].length; //列数
        int i = m -1;
        int j = 0;
        while (i>=0 && j<n){
            if(array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                j++;
            }else {
                i--;
                continue;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] array = {{2,5,6},
                {3,6,7},
                {4,7,9}};
        int[][] array1 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 16;
        System.out.println(Find2(target,array1));
    }
}
