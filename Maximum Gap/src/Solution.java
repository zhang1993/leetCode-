import java.util.Arrays;

/**
 * Created by Shinelon on 2017/6/30.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().maximumGap(new int[]{2,3,5,6,0}));
    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int result = 0;
        int maxValue = 0, minValue = Integer.MAX_VALUE;
        for(int i : nums) {
            maxValue = maxValue > i ? maxValue : i;
            minValue = minValue > i ? i : minValue;
        }
        int[] bucketMin = new int[nums.length ];
        int[] bucketMax = new int[nums.length ];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        int gap = (int)Math.ceil((double)(maxValue - minValue) / (nums.length - 1));
        if(gap == 0)
            return 0;
        for(int i : nums) {
            int index = (i - minValue) / gap;
            if(i < bucketMin[index]) {
                bucketMin[index] = i;
            }
            if(i > bucketMax[index]) {
                bucketMax[index] = i;
            }
        }
        boolean flag = false;
        int previous = 0;
        for(int i = 0; i < nums.length; i++) {
            if(bucketMin[i] != Integer.MAX_VALUE) {
                if(flag) {
                    result = (bucketMin[i] - previous) > result ? (bucketMin[i] - previous) : result;
                }
            }
            if(bucketMax[i] != Integer.MIN_VALUE) {
                previous = bucketMax[i];
                if(!flag)
                    flag = true;
            }
        }
        return result;
    }
}