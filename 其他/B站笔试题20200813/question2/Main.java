package B站笔试题20200813.question2;

import java.util.Stack;

/**
 * 有效括号
 * 输入: "{{()}}
 * 输出 true
 */
public class Main {
    public static void main(String[] args) {
    }

    public static boolean IsValidExp (String s) {
        // write code here
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty() || !check(stack.pop(), c)) return false;
            }

        }
        return stack.isEmpty();
    }

    private static boolean check(Character c1, char c2) {
        if(c1 == '('){
            return c2 == ')';
        }else if(c1 == '{'){
            return c2 == '}';
        }else {
            return c2 == ']';
        }
    }
}
