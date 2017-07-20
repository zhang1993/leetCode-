/**
 * Created by Shinelon on 2017/7/11.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int minLength = s.length() - 1;
        for(int i = s.length() / 2; i >= 0; i--) {
            int val = calPalindrome(s, i);
            if(val == i) {
                minLength = s.length() - 2 * i - 1;
                break;
            }else if(val == i + 1) {
                minLength = s.length() - 2 * i - 2;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(s.length() - minLength));
        return sb.reverse() + s;
    }

    public int calPalindrome(String s, int index) {
        for(int i = index, j = index + 1; i >= 0&&j <s.length();i--,j++) {
            if(s.charAt(i) != s.charAt(j))
                break;
            if(i == 0)
                return index + 1;
        }

        for(int i = index - 1, j = index + 1; i >= 0 &&j <s.length(); i--, j++) {
            if(s.charAt(i) != s.charAt(j))
                break;
            if(i == 0)
                return index;
        }
        return 0;

    }
}