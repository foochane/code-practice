package pig;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;

        n = cin.nextInt();

        int[] array = new int[n];

        int num = 4*n;

        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }

//        System.out.println(Arrays.toString(data));

        for (int i = 0; i < array.length; i++) {

            System.out.println(getCount(array[i]));
        }

    }

    private static int getCount(int n) {

        int num = 4 * n;
        ListNode head = new ListNode(0);

        for (int i = 1; i < num-1; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
        }
        ListNode tail = new ListNode(num-1);
        tail.next = head;

        int count = 0;
        int result = 0;

        while (count == 2){
            result++;
            // 走n+1步
            for (int k = 0; k < n+1; k++) {
                ListNode temp = head.next;
                head = temp;
            }
            if(head.val == n+1){
                count ++;
            }
        }
        return result;
    }
}
