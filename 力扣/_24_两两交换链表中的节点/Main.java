package _24_两两交换链表中的节点;

import java.util.Objects;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String[] num = cin.nextLine().split(" ");

        // 构造链表
        ListNode head = new ListNode(Integer.parseInt(num[0]));
        ListNode cur = head;
        for (int i = 1; i < num.length; i++) {
            ListNode temp = new ListNode(Integer.parseInt(num[i]));
            cur.next = temp;
            cur  = cur.next;
        }

        // 反转后的链表cur
        cur = swapPairs2(head);

        //输出链表
        while(cur != null){
            System.out.print(cur.val);
            cur = cur.next;
            if(cur != null){
                System.out.print(" ");
            }
        }
    }


    // 使用递归
    public static ListNode swapPairs1(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 交换 顺序不能颠倒！！！！！
        firstNode.next = swapPairs1(secondNode.next);
        secondNode.next = firstNode;

        return  secondNode;
    }

    public static ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null) return  head;

        ListNode swapNode = new ListNode(-1);
        swapNode.next = head;
        ListNode cur = swapNode;

        // -1 1 2 3 4 5 6
        while (cur.next != null && cur.next.next != null ){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = temp;


        }
        return swapNode.next;
    }


}
