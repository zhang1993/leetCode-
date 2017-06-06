import java.util.Stack;

/**
 * Created by Shinelon on 2017/6/6.
 */
public class Solution {
    public static void main(String[] args) {
        int[] heights = new int[]{1,2,3,4,5,6};
        System.out.print(new Solution().largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxSize = 0;
        for(int i = 0; i <= heights.length; i++) {
            if(i == heights.length) {
                if(stack.isEmpty())
                    break;
                int index = stack.pop();
                int newLength = 0;
                if(stack.isEmpty())
                    newLength = i;
                else
                    newLength = i - 1 - stack.peek();
                if(newLength * heights[index] > maxSize)
                    maxSize = heights[index] * newLength;
                i--;
            }else if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i);
            else {
                int index = stack.pop();
                int newLength = 0;
                if(stack.isEmpty())
                    newLength = i;
                else
                    newLength = i - 1 - stack.peek();
                if(newLength * heights[index] > maxSize)
                    maxSize = heights[index] * newLength;
                i--;
            }

        }
        return maxSize;

    }
}