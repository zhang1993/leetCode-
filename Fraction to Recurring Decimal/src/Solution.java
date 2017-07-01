import java.util.HashMap;

/**
 * Created by Shinelon on 2017/7/1.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1,6));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        String result = "";
        HashMap<Long, Integer> map = new HashMap<>();
        boolean flag = false;
        long numer = numerator,denomin = denominator;
        if(numer < 0) {
            numer = -numer;
            flag = !flag;
        }
        if(denomin < 0) {
            denomin = -denomin;
            flag = !flag;
        }
        long remain = numer;
        int step = 0;
        if(remain >= denomin) {
            result += remain / denomin;
            remain = remain % denomin;
        }
        if(result.length() == 0)
            result += "0";
        result += ".";
        while(remain != 0) {
            remain *= 10;
            if(map.get(remain) == null) {
                map.put(remain, step);
            }else{
                int index = result.length() - (step - map.get(remain));
                result = result.substring(0, index) + "(" + result.substring(index);
                result += ")";
                break;
            }
            step++;
            result += remain / denomin;
            remain = remain % denomin;
        }
        if(result.charAt(result.length() - 1) == '.') {
            result = result.substring(0,result.length() - 1);
        }
        if(flag)
            result = "-" + result;
        return result;
    }
}