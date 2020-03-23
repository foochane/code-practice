package _05_用两个栈实现队列;

import java.util.Stack;

/**
 *《剑指Offer_编程题-用两个栈实现队列》
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 *
 * 20200323
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 栈：先进后出
    // 队列： 先进先出

    // 方法一：
    // stack1用来存push的数，stack2用来存pop的数。
    // 每次push都判断stack2中是否有数，有数则先把stack2中的数放到stack1中，再push新的数字，
    // push完成后，把stack1中的数字依次放到stack2中
    public void push1(int node) {
        if(stack2.empty()){
            stack1.push(node);
        }else {
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop1() {
        return stack2.pop();
    }

    // 方法二
    // 改进方法一，方法一有个问题，每次push新的数字的时候都要，把stack2中的原来数据放到stack1，然后push新的数字，
    // 接着再把stack1的数据放到stack2。也就是每次psh新的数字都要，遍历一遍stack1和stack2。
    // 改进：还是stack1用来存push的数，stack2用来存pop的数。只有stack2中没有数字才去stack1中取。
    public void push2(int node){
        stack1.push(node);
    }

    public int pop2(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
