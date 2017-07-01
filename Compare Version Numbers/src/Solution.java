/**
 * Created by Shinelon on 2017/7/1.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.0","1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] verInfo1 = version1.split("\\.");
        String[] verInfo2 = version2.split("\\.");
        int i = 0;
        while(true) {
            if(i < verInfo1.length && i < verInfo2.length) {
                int a = Integer.valueOf(verInfo1[i]);
                int b = Integer.valueOf(verInfo2[i]);
                if(a > b)
                    return 1;
                else if(a < b)
                    return -1;
                else{

                }
                i++;
            }else{
                break;
            }
        }

        if(i == verInfo1.length && i == verInfo2.length)
            return 0;
        if(i == verInfo1.length) {
            for(int j = i; j < verInfo2.length; j++) {
                if(Integer.valueOf(verInfo2[j]) != 0)
                    return -1;
            }
            return 0;
        }
        else {
            for(int j = i; j < verInfo1.length; j++) {
                if(Integer.valueOf(verInfo1[j]) != 0)
                    return 1;
            }
            return 0;
        }

    }
}