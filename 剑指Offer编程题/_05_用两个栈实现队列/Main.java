package _05_用两个栈实现队列;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.push2(1);
        s.push2(2);
        s.push2(3);
        s.pop2();
        s.push2(4);
        s.pop2();
        s.push2(5);

        System.out.println(s.pop2());


    }
}
