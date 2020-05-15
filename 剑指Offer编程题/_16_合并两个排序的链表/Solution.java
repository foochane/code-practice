package _16_合并两个排序的链表;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 *
 * 20200115
 */

public class Solution {

    // 方法一
    // 取出两个链表的值，排序，再合成新的链表
    // 好蠢的方法。。。
    public ListNode Merge(ListNode list1,ListNode list2) {

        List<Integer> list = new ArrayList<>();
        while (list1 != null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null){
            list.add(list2.val);
            list2 = list2.next;
        }
        if(list.isEmpty()){
            return null;
        }
        Object[] array = list.toArray();
        Arrays.sort(array);

        ListNode newList = new ListNode((Integer) array[0]);
        ListNode temp = newList;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode((Integer) array[i]);
            temp.next = node;
            temp = node;
        }

        return newList;
    }

    // 方法二
    // 新建一个链表，同时遍历list1和list2的值，小的先放进新链表里。
    // 如果list1和list2中有一个为空时，把另外一个不为空的链表放在新链表后面。
    public ListNode Merge1(ListNode list1,ListNode list2) {

        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }

        return newList.next;
    }


}