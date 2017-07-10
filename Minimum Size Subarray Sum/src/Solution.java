/**
 * Created by Shinelon on 2017/7/10.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7,new int[]{1,2,3,4,5}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        int result = 0;
        int sum = 0;
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[right] + sum >= s) {
                if(result == 0)
                    result = right - left + 1;
                else
                    result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
                if(left > right) {
                    right = left;
                    sum = 0;
                }
                if(result == 1)
                    return 1;
            }else{
                sum += nums[right];
                right++;
            }
        }
        return result;
    }
}