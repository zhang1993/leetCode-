import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Shinelon on 2017/6/16.
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        System.out.print(new Solution().longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
//        HashSet<Integer> numSet = new HashSet(Arrays.asList(nums));
//        System.out.print(Arrays.asList(nums))
//         note,基本数据类型不能直接用asLList转
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }
        HashSet<Integer> curSet = new HashSet<>();
        int maxLength = 0;
        int curLength = 0;
        for(int num : nums) {
            if(!curSet.contains(num)) {
                curLength = 1;
                int afterNum = num + 1;
                int preNum = num - 1;
                curSet.add(num);
                while(numSet.contains(afterNum)) {
                    curLength++;
                    afterNum++;
                    curSet.add(afterNum);
                }
                while(numSet.contains(preNum)) {
                    curLength++;
                    preNum--;
                    curSet.add(preNum);
                }
                if(curLength > maxLength) {
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }
}