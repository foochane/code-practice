import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args)  {

        //一个队里有固定长度，每次加入或者删除时，得到当前队列中的最小值
        MyQueue queue = new MyQueue(3);
        int[] nums = {2, 1, 3, 6, 9, 10, 34, 8};
        for (int num : nums) {
            queue.add(num);
            System.out.println(num + "," + queue.getMin());
        }

    }
}

class MyQueue{
    private final int size;
    PriorityQueue<Integer> sortedQueue = new PriorityQueue<>();
    Deque<Integer> queue = new LinkedList<>();
    MyQueue(int size){
        this.size = size;
    }

    public void add(int num){
        if(queue.size() >= size){
            sortedQueue.remove(queue.getFirst());
            queue.removeFirst();
        }
        queue.addLast(num);
        sortedQueue.add(num);
    }

    public int getMin(){
        return sortedQueue.size() > 0 ? sortedQueue.peek() : 0;
    }
}