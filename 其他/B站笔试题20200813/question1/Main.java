package B站笔试题20200813.question1;


import java.util.Scanner;

/**
 * 给出4个1—10的数字，通过加减乘除，得到数字24
 * 示例：
 * 输入 7,2，1,10
 * 输出 true
 * 说明：7*2+1*10
 */

public class Main {

    public static boolean ans = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0.0;
        int[] num = new int[4];

        while(sc.hasNextInt()){
            boolean[] visited = new boolean[4];
            for(int i= 0;i < 4;i++){
                num[i] = sc.nextInt();
            }
            check(num, visited, result);
            System.out.println(ans);
        }

        sc.close();

    }

    private static void check(int[] num,boolean[] visited,double result) {
        if(result == 24) ans = true;

        //不用设置终止条件， visited都为true就终止了
        for(int i=0;i<num.length;i++){
            if(!visited[i]){
                visited[i] = true;
                check(num,visited,result+num[i]);
                check(num,visited,result-num[i]);
                check(num,visited,result*num[i]);
                check(num,visited,result/num[i]);
                visited[i] = false;
            }
        }
    }
}
