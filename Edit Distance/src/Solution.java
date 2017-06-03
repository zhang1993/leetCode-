/**
 * Created by Shinelon on 2017/6/3.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().minDistance("abcd","acd"));
    }
    public int minDistance(String word1, String word2) {
        int dpArray[][] = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word2.length(); i++)
            dpArray[0][i] = i;
        for(int i = 0; i <= word1.length(); i++)
            dpArray[i][0] = i;
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dpArray[i][j] = dpArray[i - 1][j - 1];
                else
                    dpArray[i][j] = Math.min(Math.min(dpArray[i - 1][j - 1],dpArray[i][j - 1]),dpArray[i - 1][j]) + 1;
            }
        }
        return dpArray[word1.length()][word2.length()];
    }
}