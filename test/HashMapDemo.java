import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {

        // 查询快，无序
        Map<Integer,Integer> map = new HashMap<>();

        // 1 插入
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        // 2 获取
        int v1 = map.get(1);  // 根据key获取value
        Collection<Integer> values = map.values();//获取values
        Set<Integer> keys = map.keySet(); // 获取keys

        // 3 遍历
        // 遍历keys
        for(Integer k : map.keySet()) {
            System.out.println(k);
            System.out.println(map.get(k));
        }
        // 遍历values
        for(Integer v : map.values()){
            System.out.println(v);
        }

        // 4 修改value
        // 直接使用put如果key存在则修改，不存在则插入
        map.put(1,-1);

        // 5 map信息
        int size = map.size(); // 大小
        boolean isEmpty = map.isEmpty(); // 是否为空
        boolean isContainKey = map.containsKey(1); // 是否包含某个key
        boolean isContainValue = map.containsValue(-1); //是否包含某个value

        // 6 删除
        // 根据key删除
        map.remove((Integer)3); // 注意传的是Object

        // 7 清空
        map.clear();

    }
}
