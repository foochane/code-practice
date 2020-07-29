import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        hashSet.add(3);
        treeSet.add(3);
        linkedHashSet.add(3);

        hashSet.add(2);
        treeSet.add(2);
        linkedHashSet.add(2);

        hashSet.add(5);
        treeSet.add(5);
        linkedHashSet.add(5);

        hashSet.add(1);
        treeSet.add(1);
        linkedHashSet.add(1);

        System.out.println(hashSet.toString());
        System.out.println(treeSet.toString());
        System.out.println(linkedHashSet.toString());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }


}



