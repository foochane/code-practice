package Children;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);

        n = cin.nextInt();
        int[][] data = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            while (cin.hasNext()){
                int temp = cin.nextInt();
                if(temp != 0){
                    data[i+1][temp] = 1;
                }else {
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(data));

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if(data[i][j] != data[j][i]){
                    list1.add(i);
                    list2.add(j);
                    break;
                }else {
                    for (int item : list1){
//                        if(data[item])
                    }
                }
            }
        }

    }
}
