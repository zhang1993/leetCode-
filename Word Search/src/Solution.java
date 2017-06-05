/**
 * Created by Shinelon on 2017/6/5.
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c'},{'b','c','d'}};
        System.out.print(new Solution().exist(board,"abc"));
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] boardInfo = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(findWord(board, boardInfo, i, j, 0, word))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, boolean[][] boardInfo, int i, int j, int index, String word) {
        if(index == word.length() - 1 && board[i][j] == word.charAt(index))
            return true;
        if(board[i][j] == word.charAt(index)) {
            boardInfo[i][j] = true;
            if(i > 0 && boardInfo[i - 1][j] == false) {
                if(findWord(board, boardInfo, i - 1, j, index + 1, word))
                    return true;
            }

            if(i < board.length - 1 && boardInfo[i + 1][j] == false) {
                if(findWord(board, boardInfo, i + 1, j, index + 1, word))
                    return true;
            }

            if(j > 0 && boardInfo[i ][j - 1] == false) {
                if(findWord(board, boardInfo, i, j - 1, index + 1, word))
                    return true;
            }

            if(j < board[0].length - 1 && boardInfo[i ][j + 1] == false) {
                if(findWord(board, boardInfo, i, j + 1, index + 1, word))
                    return true;
            }
            boardInfo[i][j] = false;
        }
        return false;

    }
}