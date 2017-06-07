import java.util.Stack;

/**
 * Created by Shinelon on 2017/6/7.
 */
public class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','1'},{'1','1'},{'0','1'}};
        System.out.print(new Solution().maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length <= 0)
            return 0;
        if(matrix[0].length <= 0)
            return 0;
        int[][] heightInfo = new int[matrix.length][matrix[0].length];
        int[][] widthInfo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == '1') {
                heightInfo[0][i] = 1;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    heightInfo[i][j] = heightInfo[i - 1][j] + 1;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++) {
            stack.clear();
            for(int j = 0; j <= matrix[0].length; j++) {
                int h = j == matrix[0].length ? 0 : heightInfo[i][j];
                if(stack.isEmpty() || h >= heightInfo[i][stack.peek()]) {
                    stack.push(j);
                }else{
                    int height = heightInfo[i][stack.pop()];
                    int value = stack.isEmpty() ? -1 : stack.peek();
                    if(height * (j - 1 - value) > maxArea) {
                        maxArea = height * (j - 1 - value);
                    }
                    j--;
                }
            }
        }
        return maxArea;
    }
}