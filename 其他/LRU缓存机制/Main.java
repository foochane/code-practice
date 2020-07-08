package LRU缓存机制;


import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    //注意的问题：只要访问或者修改的值要排在前面
    private LinkedList<Integer> list = new LinkedList<>(); // 用于排序
    private HashMap<Integer,Integer> map = new HashMap<>(); // 存key和value
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        int value = map.get(key);
        list.remove((Integer) key);
        list.addFirst(key);

        return value;

    }

    public void put(int key, int value) {

        //判断key是否存在，则修改
        if(map.containsKey(key)){
            map.put(key,value);
            //排在前面
            list.remove((Integer) key);
            list.addFirst(key);
            return;
        }
        // 容量打印capacity,则删除末尾的数
        if(list.size()>= capacity){
            int last = list.getLast();
            map.remove(last);
            list.removeLast();
        }
        list.addFirst(key);
        map.put(key,value);
    }
}


public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }
}
