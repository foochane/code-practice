package 只出现过一次的数;

import java.util.*;

public class Main{

    public static void main(String args[]){

        Scanner cin = new Scanner(System.in);
        int i,n;

        // 输入数据，第一个数表示数组的个数，后面的数为数组里的数组
        n = cin.nextInt();
        int[] num = new int[n];
        for(i = 0; i < n; i++){
            num[i] = cin.nextInt();
        }

        List<Integer> list = getNums(num);

        System.out.println(list.toString());
    }

    public static List<Integer> getNums(int[] num){

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < num.length; i++){
            map.put(num[i],map.getOrDefault(num[i],0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }

        return list;
    }
}