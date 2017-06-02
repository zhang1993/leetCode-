/**
 * Created by Shinelon on 2017/6/2.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().isNumber(".3e10"));
    }
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.equals(""))
            return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);

        int numOfPoint = 0;
        int numOfE = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.')
                numOfPoint++;
            if(s.charAt(i) == 'e')
                numOfE++;
        }
        if(numOfPoint >= 2 || numOfE >= 2)
            return false;

        int flag = 0;

        boolean flag1 = true;
        boolean flag2 = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c <= '9' && c >= '0') {
                if(flag == 0) {
                    flag = 1;
                }else if(flag == 2){
                    flag = 1;
                }else if(flag == 4 || flag == 3) {
                    flag = 5;
                }

            }else if(c == '.') {
                if(flag == 0)
                    flag = 2;
                else if(flag == 1)
                    flag = 1;
                else
                    return false;
            }else if(c == 'e') {
                if(flag == 1)
                    flag = 3;
                else
                    return false;
            }else if(c == '+' || c == '-') {
                if(flag == 3)
                    flag = 4;
                else
                    return false;
            }else {
                return false;
            }
        }
        if(flag == 1 ||  flag == 5)
            return true;
        return false;
    }
}