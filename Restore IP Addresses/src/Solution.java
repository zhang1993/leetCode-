import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shinelon on 2017/6/13.
 */
public class Solution {
    List<String> ipList = new LinkedList<>();

    public static void main(String[] args) {
        System.out.print(new Solution().restoreIpAddresses("25525511135"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        getIpAddress(list, s, "", 0);
        return list;
    }

    public void getIpAddress(List<String> list, String s, String cur, int length) {
        if(s.length() == 0)
            return;
        if(length == 3) {
            if(s.length() > 3)
                return;

            if((s.length() == 3 || s.length() == 2 )&& s.charAt(0) != '0' && Integer.valueOf(s) <= 255) {
                cur = cur + "." + s;
                list.add(cur);
            }

            if(s.length() == 1 ) {
                cur = cur + "." + s;
                list.add(cur);
            }
            return;
        }else {
            if(length != 0)
                cur = cur + ".";
            if(s.charAt(0) == '0') {
                getIpAddress(list, s.substring(1), cur + "0", length + 1);
            }else {
                if(s.length() >= 1)
                    getIpAddress(list, s.substring(1), cur + s.substring(0, 1), length + 1);
                if(s.length() >= 2)
                    getIpAddress(list, s.substring(2), cur + s.substring(0, 2), length + 1);
                if(s.length() >= 3 && Integer.valueOf(s.substring(0,3)) <= 255)
                    getIpAddress(list, s.substring(3), cur + s.substring(0, 3), length + 1);
            }
        }
    }
}