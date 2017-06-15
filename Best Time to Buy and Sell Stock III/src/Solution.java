/**
 * Created by Shinelon on 2017/6/15.
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,5};
        System.out.print(new Solution().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int maxPre = 0, minPre = Integer.MAX_VALUE,maxAfter = 0, minAfter = Integer.MAX_VALUE;
        int maxDValue = 0;
        int[] dPreValue = new int[prices.length];
        int[] dAfterValue = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPre) {
                minPre = prices[i];
            }
            if(prices[i] - minPre > maxDValue) {
                dPreValue[i] = prices[i] - minPre;
                maxDValue = dPreValue[i];
            }
            else
                dPreValue[i] = (i == 0) ? 0 : dPreValue[i - 1];
        }
        maxDValue = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] > maxAfter) {
                maxAfter = prices[i];
            }
            if(maxAfter - prices[i] > maxDValue) {
                dAfterValue[i] = maxAfter - prices[i];
                maxDValue = dAfterValue[i];
            }else
                dAfterValue[i] = (i == prices.length - 1) ? 0 : dAfterValue[i + 1];
        }
        maxDValue = 0;
        for(int i = 0; i < prices.length; i++){
            int count = dAfterValue[i] + dPreValue[i];
            if(count > maxDValue)
                maxDValue = count;
        }
        return maxDValue;
    }
}