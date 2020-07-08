package 计算数组平方后不相同数的个数;

import java.util.*;

public class Main{
    public static void main(String[] agrs){
        int[] arr = {-1,-1,1,2,3,3,4,5};
        int count = countRepeat(arr);
        System.out.println(count);
    }

    public static int countRepeat(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(num < 0) num = -num;
            set.add(num);
        }

        return set.size();

    }
}