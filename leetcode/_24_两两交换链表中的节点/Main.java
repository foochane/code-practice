package _24_两两交换链表中的节点;

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
        cur = swapPairs(head);

        //输出链表
        while(cur != null){
            System.out.print(cur.val);
            cur = cur.next;
            if(cur != null){
                System.out.print(" ");
            }
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // 相邻链表反转
        ListNode reHead = new ListNode(-1);
        ListNode cur = head;
        reHead.next = head;
        cur = reHead;
        while(cur.next != null && cur.next.next != null){
            ListNode temp = cur.next;
            cur.next = temp.next;//
            temp.next = cur.next.next ;
            cur.next.next = temp;
            cur = temp;
        }

        // 反转后的链表
        return reHead.next;
    }
}
