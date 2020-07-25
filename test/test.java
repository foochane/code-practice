

import java.util.*;


public class test {


    public static void main(String[] args) {
        int amount = 5;
        int coins[] = {1, 2, 5};


        System.out.println(change(amount, coins));
        System.out.println(set.toString());


    }


    private static Set<Integer> set = new HashSet<>();
    public static int change(int amount, int[] coins) {

        recur(0, "" , amount, coins);
        return set.size();
    }

    public static void recur(int curAmount, String str, int amount, int[] coins){
        if(curAmount == amount){
            System.out.println(str);
            set.add(str.length());
            return;
        }
        if(curAmount > amount) return;

        for(int coin : coins){
            recur(curAmount + coin, str + coin, amount, coins);
        }
    }
}


