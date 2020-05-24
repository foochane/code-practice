package _20_包含min函数的栈;

import java.util.Stack;
/**
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 *
 * 20200524
 */


public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();


    public void push(int node) {
        if(stack.isEmpty()){
            min.push(node);
        }else {
            if(node < min.peek()){
                min.push(node);
            }else {
                min.push(min.peek());
            }
        }
        stack.push(node);

    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}