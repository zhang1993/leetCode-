import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shinelon on 2017/6/5.
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        for(List<Integer> list : new Solution().subsets(nums))
            System.out.print(list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        return getSubsets(0, nums);
    }

    public List<List<Integer>> getSubsets(int index, int[] nums) {
        if(index == nums.length) {
            LinkedList<Integer> returnList = new LinkedList<>();
            LinkedList<List<Integer>> returnSubsets = new LinkedList<List<Integer>>();
            returnSubsets.add(returnList);
            return returnSubsets;
        }
        List<List<Integer>> tempSubsets = getSubsets(index + 1, nums);
        List<List<Integer>> resultSubsets = new LinkedList<List<Integer>>();
        for(List<Integer> list : tempSubsets) {
            List<Integer> newList = new LinkedList<>();
            for(Integer num : list) {
                newList.add(num);
            }
            newList.add(nums[index]);
            resultSubsets.add(newList);
            resultSubsets.add(list);
        }

        return resultSubsets;
    }
}