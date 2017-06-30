/**
 * Created by Shinelon on 2017/6/30.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(455));
    }
    public String convertToTitle(int n) {
        String result = "";
        int cur = n;
        while(cur > 0) {
            if(cur % 26 == 0) {
                result = "Z" + result;
                cur = (cur - 26) / 26;
            }
            else {
                result = String.valueOf((char)('A' + cur % 26 - 1)) + result;
                cur = cur / 26;
            }
        }
        return result;
    }
}