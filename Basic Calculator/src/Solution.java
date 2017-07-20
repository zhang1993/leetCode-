import java.util.Stack;

/**
 * Created by Shinelon on 2017/7/20.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("9 - (0 + 2)"));
    }
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int cur = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                if(cur != 0)
                    cur = cur * 10 + c - '0';
                else
                    cur = c - '0';
                if(i == s.length() - 1 || s.charAt(i + 1) > '9' || s.charAt(i + 1) <'0') {
                    if(numStack.size() == 0 || numStack.peek() == -Integer.MAX_VALUE)
                        numStack.push(cur);
                    else {
                        int pre = numStack.pop();
                        char op = operatorStack.pop();
                        if(op == '-')
                            numStack.push(pre - cur);
                        else
                            numStack.push(pre + cur);
                    }
                    cur = 0;
                }
            } else if(c != ' ') {
                if(c == '-' || c == '+')
                    operatorStack.push(c);
                else if(c == '(') {
                    numStack.push(-Integer.MAX_VALUE);
                }else{
                    int next = numStack.pop();
                    numStack.pop();
                    if(numStack.size() == 0 || numStack.peek() == -Integer.MAX_VALUE)
                        numStack.push(next);
                    else {
                        int pre = numStack.pop();
                        char op = operatorStack.pop();
                        if(op == '-')
                            numStack.push(pre - next);
                        else
                            numStack.push(pre + next);
                    }
                }
            }
        }
        if(numStack.size() == 1)
            return numStack.peek();
        else{
            int after = numStack.pop();
            int pre = numStack.pop();
            char c = operatorStack.pop();
            if(c == '-')
                return pre - after;
            else
                return pre + after;
        }
    }
}