import java.util.Arrays;

/**
 * Created by Shinelon on 2017/7/4.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(1,new int[]{1,2}));
    }
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0)
            return 0;
        if(k >= prices.length)
            return linearFind(prices);
        int[] buyInfo = new int[k + 1];;
        int[] sellInfo = new int[k + 1];
        Arrays.fill( buyInfo, Integer.MIN_VALUE);
        Arrays.fill(sellInfo, 0);
        for(int i = 0; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                if(sellInfo[j - 1] - prices[i] > buyInfo[j]) {
                    buyInfo[j] = sellInfo[j - 1] - prices[i];
                }
                if(buyInfo[j] + prices[i] >= sellInfo[j] ) {
                    sellInfo[j] = buyInfo[j] + prices[i];
                }
            }
        }
        return sellInfo[k];
    }
    public int linearFind(int[] prices) {
        int pre = prices[0];
        int sum = 0;
        for(int i : prices) {
            if(i > pre) {
                sum += (i - pre);
            }
            pre = i;
        }
        return sum;
    }
}