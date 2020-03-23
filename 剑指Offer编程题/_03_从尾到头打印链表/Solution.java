package _03_从尾到头打印链表;

/**
 * 《剑指Offer_编程题-从尾到头打印链表》
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035
 *
 * 20200303
 */
import java.util.ArrayList;
import java.util.Stack;


class Solution {

    //listNode 是链表，只能从头遍历到尾，题目要求从尾到头打印

    //1 使用栈 “先进后出”
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
        ArrayList list = new ArrayList();
        Stack stack = new Stack();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    //2 利用ArrayList 中的 add(index,value)方法，从头插入
    //ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
    //所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    //3 使用递归
    ArrayList list = new ArrayList();
    public ArrayList printListFromTailToHead3(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead3(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}

