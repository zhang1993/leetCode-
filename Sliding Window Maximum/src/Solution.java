import java.util.LinkedList;

/**
 * Created by Shinelon on 2017/7/22.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSlidingWindow(new int[]{1,2,3,4,5,6,7,-3,2,4,2,3,56}, 4));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        int size = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        k = Math.min(nums.length, k);
        int[] result = new int[nums.length - k + 1];
        for(int i = 0;  i < nums.length; i++) {
            if(size <  k) {
                while(!queue.isEmpty()) {
                    if(queue.peekLast() < nums[i])
                        queue.pollLast();
                    else
                        break;
                }
                queue.add(nums[i]);
                size++;
                if(size == k)
                    result[0] = queue.peek();
            } else {
                if(nums[i - k] == queue.peek())
                    queue.poll();
                while(!queue.isEmpty()) {
                    if(queue.peekLast() < nums[i])
                        queue.pollLast();
                    else
                        break;
                }
                queue.add(nums[i]);
                result[i - k + 1] = queue.peek();
            }
        }
        return result;
    }
}