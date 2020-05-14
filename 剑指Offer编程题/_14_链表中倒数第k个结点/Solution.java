package _14_链表中倒数第k个结点;

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

    // 方法一 先统计链表长度，在反推倒数第k个节点是正数第几个节点
    // 如果链表的长度是n，则倒数第k个节点就是正数第n-k个节点
    public ListNode FindKthToTail1(ListNode head, int k) {
        int n;

        if(head == null){
            return null;
        }else {
            n = 1;
        }
        ListNode listHead = head;
        while (listHead.next != null){
            n++;
            listHead = listHead.next;
        }
        if(k>n){
            return null;
        }
        int i = 1;
        while (i<=n-k && head != null){
            head = head.next;
            i++;
        }
        return head;
    }

    // 方法二 取两个指针，第一个指针在链表的第1个位置，第2个指针在链表的第k+1个位置
    // 两个指针同时往后移动，第2个指针刚指向null时，第1个节点指向倒数第k个节点
    // 如果链表的长度是n，则倒数第k个节点就是正数第n-k个节点
    public ListNode FindKthToTail2(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int i = 1;
        while (i<=k){
            node2 = node2.next;
            if(node2 == null){
                if(i==k){        // 5,{1,2,3,4,5}
                    return node1;
                }
                return null;
            }
            i++;
        }


        while (node2 != null){

            node2 = node2.next;
            node1 = node1.next;
        }
        return node1;

    }

    // 方法三 使用堆栈存
    public ListNode FindKthToTail3(ListNode head, int k) {

        if(k<=0){ // 0,{1,2,3,4,5}
            return null;
        }
        Stack<ListNode> stack  = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }

        int i = 1;
        while (i<=k-1){
            if(stack.isEmpty()){
                return null;
            }
            stack.pop();
            i++;
        }

        if(stack.isEmpty()){
            return null;
        }
        return stack.pop();
    }
}