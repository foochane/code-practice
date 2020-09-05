package 百度20200903.question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //T组测试数据
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); //牛的数量
            int[] count = new int[n + 1];
            List<Integer> nums = new ArrayList<>();
            int m = sc.nextInt(); //特性数量
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt(); //区间数量
                for (int x = 0; x < k; x++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    //for (int y = l; y <= r; y++) {
                    //    count[y] = count[y] + 1;
                    //    if(count[y] == m)  nums.add(y);
                    //}
                    for (int y = 1; y < count.length; y++) {
                        if(l <= y && y <= r){
                            count[y] = count[y] + 1;
                            if(count[y] == m)  nums.add(y);
                        }
                    }
                }
            }
            System.out.println(nums.size());
            for (int z = 0; z < nums.size(); z++) {
                System.out.print(nums.get(z));
                if(z != nums.size() -1) {
                    System.out.print(" ");
                }else {
                    System.out.println();
                }
            }

        }

    }
}

/*
1
10 2
3
1 2
4 5
8 8
2
1 4
6 8


4
1 2 4 8
 */