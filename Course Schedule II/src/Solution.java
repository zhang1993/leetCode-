import java.util.ArrayList;

/**
 * Created by Shinelon on 2017/7/10.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findOrder(2,new int[][]{{0,1}}));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] courseInfo = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            courseInfo[i] = new ArrayList<>();
        }
        for(int[] temp : prerequisites) {
            courseInfo[temp[1]].add(temp[0]);
        }

        int[] flag = new int[numCourses];
        int[] takeCourse = new int[numCourses];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(flag[i] != 1) {
                if(!dfsSearch(courseInfo, i, flag, result)) {
                    return new int[0];
                }
            }
        }
        int cur = 0;
        for(int i : result) {
            takeCourse[cur] = i;
            cur++;
        }
        return takeCourse;
    }

    public boolean dfsSearch(ArrayList<Integer>[] courseInfo, int start, int[] flag, ArrayList<Integer> result) {
        flag[start] = -1;
        boolean error = true;
        for(int i : courseInfo[start]) {
            if(flag[i] == 0)
                error = error && dfsSearch(courseInfo, i, flag, result);
            else if(flag[i] == -1)
                return false;
        }
        result.add(0, start);
        flag[start] = 1;
        return error;
    }
}