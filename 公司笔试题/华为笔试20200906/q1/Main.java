package 华为笔试20200906.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int A = 0;
        while(sc.hasNext()){
            String s = sc.next();
            if(s.length() == 1){
                A = Integer.parseInt(s);
                break;
            }
            list.add(s);
        }
        String t = sc.next();

        String target = "";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(c - '0' < A){
                target = target + c;
            }
        }

        for (String s : list) {
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c - '0' < A){
                    temp = temp + c;
                }
            }
            if(temp.contains(target)){
                System.out.println(s);
            }
        }

        //System.out.println(target);
        //System.out.println(list.toString());

    }
}

/*
135682318  121
23457 2
14282123  12212
14231728  1212
3
1724153  121
 */