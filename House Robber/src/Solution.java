/**
 * Created by Shinelon on 2017/6/30.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1,2,3,4,5}));
    }
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] robNum = new int[nums.length];
        robNum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i == 1) {
                robNum[i] = Math.max(nums[i], nums[i - 1]);
            }else{
                robNum[i] = nums[i] + robNum[i - 2] > robNum[i - 1] ? nums[i] + robNum[i - 2] :robNum[i - 1];
            }
        }
        return robNum[nums.length - 1];
    }
}