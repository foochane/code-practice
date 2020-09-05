package 百度20200903.question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zero = 0, five = 0;
        for (int i = 0; i < n; i++) {
            int num  = sc.nextInt();
            if(num == 0) zero++;
            if(num == 5) five++;
        }

        System.out.println(zero);
        System.out.println(five);

        if(five < 9 || zero < 1){
            System.out.print(-1);
            return;
        }

        String ans = "5555555550";
        five -= 9;
        zero -= 1;
        while (five > 0){
            ans = "5" + ans;
            five--;
        }
        while (zero > 0){
            ans = ans + "0";
            zero--;
        }

        System.out.print(ans);

    }
}

/*
11
5 5 5 5 5 5 5 5 0 5 5

5555555550
 */
/*
555555555
5055555555
5505555555
5550555555
5555055555
5555505555
5555550555
5555555055
5555555505
5555555550
 */