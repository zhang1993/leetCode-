/**
 * Created by Shinelon on 2017/7/1.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{1,-1},{3,-6},{-8,1}};
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0)
            return 1;
        int[][] dpArray = new int[dungeon.length][dungeon[0].length];

        for(int i = dungeon.length - 1; i >= 0; i--) {
            for(int j = dungeon[0].length - 1; j >= 0; j--) {
                if(i == dungeon.length - 1 && j == dungeon[0].length - 1)
                    dpArray[i][j] = -dungeon[i][j];
                else if(i == dungeon.length - 1)
                    dpArray[i][j] = dpArray[i][j + 1] - dungeon[i][j];
                else if(j == dungeon[0].length - 1)
                    dpArray[i][j] = dpArray[i + 1][j] - dungeon[i][j];
                else
                    dpArray[i][j] = Math.min(dpArray[i + 1][j], dpArray[i][j + 1]) - dungeon[i][j];
                if(dpArray[i][j] < 0)
                    dpArray[i][j] = 0;
            }
        }
        int result = dpArray[0][0] + 1;
        if(result <= 0)
            result = 1;
        return result;
    }
}