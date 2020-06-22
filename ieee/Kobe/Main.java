package Kobe;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //<倒序对的数量，第i组数>
        Map<Integer,Integer> map = new HashMap<>();

        Scanner cin = new Scanner(System.in);
        int n, m;

        n = cin.nextInt();
        m = cin.nextInt();
        int[][] data = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = cin.nextInt();
            }
        }

        for (int i = 0; i < data.length; i++) {

            map.put(reversePairs(data[i]),i);
        }






        Collection<Integer> keyset= map.keySet();
        List<Integer> list = new ArrayList<Integer>(keyset);

        //对key键值按字典升序排序
        Collections.sort(list);

//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            int mapKey = entry.getKey();
//            int mapValue = entry.getValue();
//            System.out.println(mapKey+":"+mapValue);
//
//        }

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {


            System.out.print(Arrays.toString(data[map.get(list.get(i))]));

            if(i < list.size()-1){
                System.out.print(", ");
            }

        }

        System.out.print("]");


     }





    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

}
