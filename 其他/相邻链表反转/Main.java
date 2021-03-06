package 相邻链表反转;
/**
 *
 * 题目：将一个单项链表中，每两个节点进行翻转
 * 输入：1->2->3->4->5->6
 * 输出：2->1->4->3->6->5
 *
 * 20200623
 */


import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

public class Main{
    public static void main(String args[]){

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

        // 相邻链表反转
        ListNode reHead = new ListNode(-1);
        reHead.next = head;
        cur = reHead;
        while(cur.next != null && cur.next.next != null){
            ListNode temp = cur.next;
            cur.next = temp.next;//
            temp.next = cur.next.next ;
            cur.next.next = temp;
            cur = temp;
        }

        // 反转后的链表cur
        cur = reHead.next;

        //输出链表
        while(cur != null){
            System.out.print(cur.val);
            cur = cur.next;
            if(cur != null){
                System.out.print(" ");
            }
        }
    }

}