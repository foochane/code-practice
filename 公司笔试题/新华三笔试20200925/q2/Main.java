package 新华三笔试20200925.q2;

import java.util.ArrayList;
import java.util.List;

/**
 * 中间因素
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(MidFactor(12));
    }

    public static long MidFactor (long val) {
        List<Long> list = new ArrayList<>();

        for (long i = 1; i <= val; i++) {
            if(val % i == 0){
                list.add(i);
            }
        }
        int size = list.size();
        return size % 2 == 0 ? list.get(size / 2 -1) : list.get((size / 2 ));
    }
}
