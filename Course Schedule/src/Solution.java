/**
 * Created by Shinelon on 2017/7/9.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1,0},{0,1}}));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  System.out.print(prerequisites.length);
        // for(int[] i : prerequisites) {
        //     for(int j : i)
        //         System.out.print(j);
        // }
        int[] flag = new int[numCourses];
        boolean result = true;
        for(int i = 0; i < numCourses; i++) {
            if(flag[i] != 1) {
                result = result && haveCircle(numCourses, i, prerequisites, flag);
                if(!result)
                    return false;
            }
        }
        return result;
    }

    public boolean haveCircle(int num, int start, int[][] prerequisites, int[] flag) {
        flag[start] = -1;
        boolean result = true;
        for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][0] == start && flag[prerequisites[i][1]] == -1) {
                return false;
            }else if(prerequisites[i][0] == start && flag[prerequisites[i][1]] == 0) {
                result = result && haveCircle(num,prerequisites[i][1] , prerequisites, flag);
                if(!result)
                    return false;
            }
        }
        flag[start] = 1;
        return result;
    }
}