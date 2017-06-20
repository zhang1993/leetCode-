/**
 * Created by Shinelon on 2017/6/20.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().minCut("abbb"));
    }
    public int minCut(String s) {
        boolean[][] dpArray = new boolean[s.length()][s.length()];
        int[] minCutInfo = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            dpArray[i][i] = true;
        }

        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i; j++) {
                if(s.charAt(j) == s.charAt(j + i)) {
                    if(i == 1) {
                        dpArray[j][j + i] = true;

                    }else{
                        dpArray[j][j + i] = dpArray[j + 1][j + i - 1];

                    }



                }
            }
        }
        int min = 0;
        for(int i = 0; i < s.length(); i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j <= i; j++) {
                if(dpArray[j][i]) {
                    if(j == 0) {
                        min = 0;
                        break;
                    }else {
                        min = Math.min(min, minCutInfo[j - 1] + 1);
                    }
                }
            }
            minCutInfo[i] = min;
        }


        return minCutInfo[s.length() - 1];
    }

}