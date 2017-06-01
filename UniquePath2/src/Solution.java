/**
 * Created by Shinelon on 2017/6/1.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.print(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dpArray = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for(int i = 0; i < obstacleGrid[0].length + 1; i++) {
            dpArray[0][i] = 0;
        }

        for(int i = 0; i < obstacleGrid.length + 1; i++) {
            dpArray[i][0] = 0;
        }

        for(int i = 1;  i < obstacleGrid.length + 1; i++) {
            for(int j = 1; j < obstacleGrid[0].length + 1; j++) {
                if(i == 1 && j == 1) {
                    dpArray[i][j] = 1 - obstacleGrid[i - 1][j - 1];
                }
                else if(obstacleGrid[i - 1][j - 1] == 1)
                    dpArray[i][j] = 0;
                else
                    dpArray[i][j] = dpArray[i - 1][j] + dpArray[i][j - 1];
            }
        }

        return dpArray[obstacleGrid.length][obstacleGrid[0].length];
    }
}