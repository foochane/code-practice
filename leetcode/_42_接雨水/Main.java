package _42_接雨水;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * https://leetcode-cn.com/problems/trapping-rain-water
 */
public class Main {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {

        //单调递减栈
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for(int num : height){

            //stack为空，或者栈顶元素大于num时，num直接入栈
            if(stack.isEmpty() || stack.peek() >= num){
                stack.push(num);
            }//stack不为空，且栈顶元素小于num
            else{
                //把小于num的元素放入queue
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                while(!stack.isEmpty() && stack.peek() < num ){
                    queue.addFirst(stack.pop());
                }
                if(!stack.isEmpty()){
                    while(!queue.isEmpty()){
                        ans += (num - queue.pollLast());
                        stack.push(num);  //保证栈单调递减
                    }
                }else{
                    int min = Math.min(num, queue.pollFirst()); //移除最左边的边界,并找最矮的柱子
                    while(!queue.isEmpty()){
                        ans += (min - queue.pollLast());
                    }
                }

                stack.push(num); //num入栈
            }
        }

        return ans;

    }
}
