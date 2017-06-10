/**
 * Created by Shinelon on 2017/6/10.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().numDecodings("12"));
    }
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        if(s.charAt(0) == '0')
            return 0;
        int[] dpArray = new int[s.length() + 1];
        dpArray[0] = 1;
        dpArray[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0'&& s.charAt(i - 1) <= '6')) {
                if(s.charAt(i - 1) == '0')
                    dpArray[i] = dpArray[i - 2];
                else
                    dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
            }else{
                if(s.charAt(i - 1) == '0')
                    dpArray[i] = 0;
                else
                    dpArray[i] = dpArray[i - 1];
            }
        }
        return dpArray[s.length()];


    }
}
