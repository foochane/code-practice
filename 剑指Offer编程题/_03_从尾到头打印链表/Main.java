package _03_从尾到头打印链表;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        listNode.next = l2;
        l2.next = l3;
        l3.next = l4;

        Solution s = new Solution();
        System.out.println(s.printListFromTailToHead3(listNode));
    }
}
