/**
 * Created by Shinelon on 2017/6/2.
 */
import java.util.*;
public class Main {
    int longestPalindromeSubseq(String s){
        // code here
        String reversedString = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reversedString += String.valueOf(s.charAt(i));
        }
        return findMaximumLongest(s, reversedString);
    }
    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        String str = jin.next();
        System.out.println(new Main().longestPalindromeSubseq(str));
    }

    public int findMaximumLongest(String s1, String s2) {
        int[][] dpArray = new int[s1.length() + 1][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++) {
            dpArray[0][i] = 0;
            dpArray[i][0] = 0;
        }
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s1.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dpArray[i][j] = dpArray[i - 1][j - 1] + 1;

                } else {
                    dpArray[i][j] = Math.max(dpArray[i - 1][j], dpArray[i][j - 1]);
                }
            }
        }

        return dpArray[s1.length()][s1.length()];
    }
}
