package 集合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>(3);
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>(set);

        arrayList1.add(0,1);
        arrayList1.add(1,2);

        int a = Integer.MAX_VALUE;
        for (int i = 0; i < a; i++) {
            arrayList1.add(i--);
        }
    }
}
