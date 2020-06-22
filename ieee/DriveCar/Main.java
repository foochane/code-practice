package DriveCar;

import java.util.*;


public class Main {
    public static void main(String[] args) {



        Scanner cin = new Scanner(System.in);
        int num = Integer.parseInt(cin.nextLine());

        int[] result = new int[num];
        // 第i租数据
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(cin.nextLine());

            int[]  a = new int[n];
            String[] s = cin.nextLine().split(" ");

            for (int k = 0; k < n; k++) {
                a[k] = Integer.parseInt(s[k]);
            }

//            System.out.println(n);
//            System.out.println(Arrays.toString(a));
            result[i] = countTime(a);
        }

        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }

        
    }

    private static int countTime(int[] a) {

        int result = 0;
        Arrays.sort(a);

        int len = a.length;

        if(len <= 3 ){
            result =  a[len -1];
        }else {
            for (int i = 2; i < len; i++) {
                result += a[i];
            }

            result += (len -3) * a[1];
        }

        return result;
    }
}
