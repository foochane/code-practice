package 物品编号排序;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(getSort(4));
        System.out.println(getSort(5));
        System.out.println(getSort(6));
    }

    public static List<List<Integer>> getSort(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 4) {
            result.add(new ArrayList<Integer>() {
                {
                    add(2);
                    add(4);
                    add(1);
                    add(3);
                }
            });
            result.add(new ArrayList<Integer>() {
                {
                    add(3);
                    add(1);
                    add(4);
                    add(2);
                }
            });
        }
        if(n <= 4) return result;


        result.clear();
        for(List<Integer> list : getSort(n-1)){
            list.add(0,-1);
            list.add(-1);
            int len = list.size();
            for(int i =0; i < len -1; i++){
                if((Math.abs(list.get(i) - n) > 1) && (Math.abs(list.get(i+1) - n) > 1)){
                    List<Integer> temp = new ArrayList<>();
                    for(int j = 1; j < len -1; j++){
                        temp.add(list.get(j));
                    }
                    temp.add(i , n);
                    result.add(temp);
                }
            }
        }

        return result;
        //1 5 3 6 4 2

    }
}
