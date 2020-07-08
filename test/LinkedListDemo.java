import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        /**
         * 优点：
         *     1 有序
         *     2 插入、删除快
         * 缺点：
         *     查询慢
         */
        LinkedList<Integer> list = new LinkedList<>();

        // 1 插入
        list.add(1); //从尾部插入，成功返回true
        list.addFirst(-1); // 从头部插入，无返回值
        list.addLast(2); // 从尾部插入，无返回值
        list.add(1,9);  // 在索引为1处插入9

        // 2 查询
        int v1 = list.get(1); // 根据索引查询
        int v2 = list.getFirst(); //第一个
        int v3 = list.getLast(); //最后一个

        // 3 修改
        list.set(1,8); //根据索引修改

        // 4 删除
        list.remove(1); //根据索引删除
        list.removeFirst(); //删除第一个
        list.removeLast(); // 删除最后一个

        // 5 信息判断
        int size = list.size();
        boolean isEmpty = list.isEmpty();
        boolean contains = list.contains(2);


        // 6 排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 7 转成数组
        Integer[] arr = (Integer[]) list.toArray();

    }
}
