import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shinelon on 2017/6/16.
 */
public class Solution {
    class Point{
        int x;
        int y;
        Point(int i, int j) {
            x = i;
            y = j;
        }
    }
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        boolean[][] boardInfo = new boolean[board.length][board[0].length];
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < boardInfo.length; i++) {
            for(int j = 0; j < boardInfo[0].length; j++) {
                if((i == 0 || i == boardInfo.length - 1 || j == 0 || j == boardInfo[0].length - 1) && board[i][j] == 'O') {
                    boardInfo[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x + 1 < board.length  && boardInfo[p.x + 1][p.y] == false&& board[p.x + 1][p.y] == 'O') {
                boardInfo[p.x + 1][p.y] = true;
                queue.add(new Point(p.x + 1, p.y));
            }
            if(p.x - 1 >= 0  && boardInfo[p.x - 1][p.y] == false && board[p.x - 1][p.y] == 'O') {
                boardInfo[p.x - 1][p.y] = true;
                queue.add(new Point(p.x - 1, p.y));
            }
            if(p.y + 1 < board[0].length  && boardInfo[p.x][p.y + 1] == false && board[p.x][p.y + 1] == 'O') {
                boardInfo[p.x][p.y + 1] = true;
                queue.add(new Point(p.x, p.y + 1));
            }
            if(p.y - 1>= 0  && boardInfo[p.x][p.y - 1] == false&& board[p.x][p.y - 1] == 'O') {
                boardInfo[p.x][p.y - 1] = true;
                queue.add(new Point(p.x, p.y - 1));
            }
        }
        for(int i = 0; i < boardInfo.length; i++) {
            for(int j = 0; j < boardInfo[0].length; j++) {
                if(boardInfo[i][j] == true) {
                    board[i][j] = 'O';
                }else
                    board[i][j] = 'X';
            }
        }
    }
}