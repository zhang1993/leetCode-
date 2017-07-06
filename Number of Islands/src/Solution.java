import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shinelon on 2017/7/6.
 */
public class Solution {
    public static void main(String[] args) {
        char[][] grid = new char[2][2];
        grid[0][0] = '1';
        grid[0][1] = '0';
        grid[1][0] = '0';
        grid[1][1] = '1';
        System.out.println(new Solution().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int sum = 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if( !flag[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, flag);
                    sum++;
                }
            }
        }
        return sum;
    }
    class Point{
        int x;
        int y;
        Point(int i, int j) {
            x = i;
            y = j;
        }
    }
    public void bfs(int x, int y, char[][] grid, boolean[][] flag) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        flag[x][y] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == '1' && !flag[p.x][p.y + 1]) {
                queue.add(new Point(p.x, p.y + 1));
                flag[p.x][p.y + 1] = true;
            }
            if(p.x + 1 < grid.length && grid[p.x + 1][p.y] == '1'&& !flag[p.x + 1][p.y] ) {
                queue.add(new Point(p.x + 1, p.y));
                flag[p.x + 1][p.y] = true;
            }
            if(p.x - 1 >= 0 && grid[p.x - 1][p.y] == '1' && !flag[p.x - 1][p.y]) {
                queue.add(new Point(p.x - 1, p.y));
                flag[p.x - 1][p.y] = true;
            }
            if(p.y - 1 >= 0 && grid[p.x][p.y - 1] == '1' && !flag[p.x][p.y - 1]) {
                queue.add(new Point(p.x, p.y - 1));
                flag[p.x ][p.y - 1] = true;
            }
        }
    }
}