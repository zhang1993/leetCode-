/**
 * Created by Shinelon on 2017/6/13.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.print(new Solution().jump(nums));
    }
    public int jump(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] jumpInfo = new int[nums.length];
        jumpInfo[nums.length - 1] = 0;
        int maxStep = nums.length;
        for(int i = 0; i < nums.length - 1; i++) {
            jumpInfo[i] = nums.length;
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= nums.length - 1)
                jumpInfo[i] = 1;
            else {
                for(int j = nums[i]; j > 0; j--) {
                    if(i + j < nums.length) {
                        if(jumpInfo[i + j] + 1 < jumpInfo[i]) {
                            jumpInfo[i] = jumpInfo[i + j] + 1;
                            if(jumpInfo[i] == 2)
                                break;
                        }
                    }
                }
            }
        }
        return jumpInfo[0];
    }
}