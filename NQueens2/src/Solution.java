/**
 * Created by Shinelon on 2017/5/30.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().totalNQueens(5));
    }
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        countNum(board, 0, n);
        return count;
    }

    public void countNum(char[][] board, int level, int n) {
        if(level == n) {
            count++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isValid(board, level, i)) {
                board[level][i] = 'Q';
                countNum(board, level + 1, n);
                board[level][i] = '.';
            }
        }

    }

    public boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'Q' && (i == x || j == y || i + j == x + y || i - j == x - y))
                    return false;
            }
        }
        return true;

    }
}
