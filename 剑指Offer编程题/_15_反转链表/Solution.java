package _15_反转链表;

import java.util.Stack;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 *
 * 20200409
 */

public class Solution {

    // 方法一 先用栈存所有节点的值，然后逆向新建一个链表返回
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        ListNode temp1,temp2;
        ListNode reListNode = new ListNode(stack.pop());
        temp1 = reListNode;
        while (!stack.isEmpty()){

            temp2 = new ListNode(stack.pop());
            temp1.next = temp2;
            temp1 = temp2;
        }
        return reListNode;
    }

    // 方法二 新建一个空链表，从头开始依次把原来的链表反着放进去
    public ListNode ReverseList2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode reListNode = null; //新链表为空
        ListNode temp;

        while (head != null){
            temp = head.next;
            head.next = reListNode; //将当前节点的下一个节点指向reListNode
            reListNode = head;
            head = temp;
        }


        return reListNode;
    }

}