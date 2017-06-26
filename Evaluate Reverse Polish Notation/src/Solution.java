import java.util.Stack;

/**
 * Created by Shinelon on 2017/6/26.
 */
public class Solution {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.valueOf(s));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("+")) {
                    stack.push(b + a);
                }else if(s.equals("-")) {
                    stack.push(b - a);
                }else if(s.equals("*")) {
                    stack.push(b * a);
                }else{
                    stack.push(b / a);
                }
            }
        }
        return stack.peek();
    }
}