package 华为笔试20200906.q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");

//        String[] source = split[0].split(" ");
//        String[] target = split[1].split(" ");
        List<String> source = new ArrayList<>();
        List<String> target = new ArrayList<>();


        for (int i = 0; i < split[0].length(); ) {
            char c = split[0].charAt(i);
            if(c == ' '){
                i++;
            }else if(c == ',' || c == '.' || c == '!' || c == '?'){
                StringBuilder ss = new StringBuilder();

                while (c == ',' || c == '.' || c == '!' || c == '?'){
                    if(c  == '?'){
                        ss.append(c);
                    }else {
                        ss.append('.');
                    }
                    i++;
                    if(i == split[0].length()){
                        break;
                    }
                    c = split[0].charAt(i);
                }
                source.add(ss.toString());
            }else {
                StringBuilder ss = new StringBuilder();

                while (c != ' ' & c != ',' & c != '.' & c != '!' & c != '?'){
                    ss.append(c);
                    i++;
                    if(i == split[0].length()){
                        break;
                    }
                    c = split[0].charAt(i);
                }
                source.add(ss.toString().toLowerCase());
            }
        }

        for (int i = 0; i < split[1].length(); ) {
            char c = split[1].charAt(i);
            if(c == ' '){
                i++;
            }else if(c == ',' || c == '.' || c == '!' || c == '?'){
                StringBuilder ss = new StringBuilder();

                while (c == ',' || c == '.' || c == '!' || c == '?'){
                    if(c  == '?'){
                        ss.append(c);
                    }else {
                        ss.append('.');
                    }

                    i++;
                    if(i == split[1].length()){
                        break;
                    }
                    c = split[1].charAt(i);
                }
                target.add(ss.toString());
            }else {
                StringBuilder ss = new StringBuilder();

                while (c != ' ' & c != ',' & c != '.' & c != '!' & c != '?'){
                    ss.append(c);
                    i++;
                    if(i == split[1].length()){
                        break;
                    }
                    c = split[1].charAt(i);
                }
                target.add(ss.toString().toLowerCase());
            }
        }



        int min = Math.min(target.size(), source.size());
        int max = Math.max(target.size(), source.size());
        int count = 0;
        for (int i = 0; i < min; i++) {
            if(!target.get(i).equals(source.get(i))){
             count ++;
            }
        }

//        System.out.println(source.toString());
//        System.out.println(target.toString());
//        String ans = "(" + (count + max - min) + "," + target.size() + ")";
//        System.out.println(ans);
        String ans = "(" + Math.abs(target.size() - source.size()) + "," + target.size() + ")";
        System.out.println(ans);


    }
}