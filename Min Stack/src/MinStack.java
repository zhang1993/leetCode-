import java.util.Stack;

/**
 * Created by Shinelon on 2017/6/22.
 */
public class MinStack {

    Stack<Integer> stack1;
    Stack<Integer>  stack2;

    /** initialize your data structure here. */
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);

        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()) {
            stack2.push(x);
            return;
        }
        if(stack2.peek() > x)
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */