/**
 * Created by Shinelon on 2017/7/23.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberToWords(12345));
    }
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        // String[] letters1 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        // String[] Letters2 = 
        // {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        // String[] letters3 =
        // {"Thousand","Million","Billion"};
        String number = String.valueOf(num);
        String result = "";
        int len = number.length();
        if(number.charAt(0) < '0' || number.charAt(0) > '9') {
            len--;
            number = number.substring(1);
        }
        while(len > 0) {
            if(len > 9) {
                int tmp = Integer.valueOf(number.substring(0, number.length() -9));
                if(tmp != 0)
                    result = result + littleToWords(tmp) + " " + "Billion" + " ";
                number = number.substring(number.length() -9);
                len = 9;
            }else if(len > 6) {
                int tmp = Integer.valueOf(number.substring(0, number.length() -6));
                if(tmp != 0)
                    result = result + littleToWords(tmp) + " " + "Million" + " ";
                number = number.substring(number.length() -6);
                len = 6;
            }else if(len > 3) {
                int tmp = Integer.valueOf(number.substring(0, number.length() -3));
                if(tmp != 0)
                    result = result + littleToWords(tmp) + " " + "Thousand" + " ";
                number = number.substring(number.length() -3);
                len = 3;
            }else {
                int tmp = Integer.valueOf(number.substring(0, number.length()));
                if(tmp != 0)
                    result = result + littleToWords(tmp);
                number = number.substring(number.length());
                len = 0;
            }
        }
        result = result.trim();
        if(result.equals(""))
            return "Zero";
        else
            return num < 0 ? "Negative" + " " + result : result;
    }

    public String littleToWords(int num) {
        String[] letters1 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] letters2 =
                {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num < 20)
            return letters1[num];
        else if(num < 100) {
            return letters2[num / 10] + ((num % 10 == 0) ? "" : " " + letters1[num % 10]);
        }else
            return letters1[num / 100] + " " +"Hundred" +  ((num % 100 == 0) ? "" : " " + littleToWords(num % 100));
    }
}