/**
 * Created by Shinelon on 2017/6/22.
 */
public class Solution {
    public static void main(String[] args) {
        int[] gas = new int[]{4,3};
        int[] cost = new int[]{2,5};
        System.out.print(new Solution().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
        }
        if(sum < 0)
            return -1;
        int cur = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            cur = cur + gas[i] - cost[i];
            if(cur < 0){
                start = i + 1;
                cur = 0;
            }
        }
        return start;
    }
    //要多思考
}