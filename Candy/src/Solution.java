/**
 * Created by Shinelon on 2017/6/22.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().candy(new int[]{0,1,1}));
    }
    public int candy(int[] ratings) {
        if(ratings.length == 1)
            return 1;

        int[] candyNum = new int[ratings.length];
        for(int i = 1; i < ratings.length - 1; i++) {
            if(ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                candyNum[i] = 1;
                for(int j = i - 1; j >= 0; j--) {
                    if(ratings[j] > ratings[j + 1]) {
                        candyNum[j] = Math.max(candyNum[j], candyNum[j + 1] + 1);
                    }else if(ratings[j] == ratings[j + 1 ]) {
                        candyNum[j] = Math.max(candyNum[j], 1);
                    }else{
                        break;
                    }
                }
                for(int j = i + 1; j < ratings.length; j++) {
                    if(ratings[j] > ratings[j - 1]) {
                        candyNum[j] = Math.max(candyNum[j], candyNum[j - 1] + 1);
                    }else if(ratings[j] == ratings[j - 1 ]) {
                        candyNum[j] = Math.max(candyNum[j], 1);
                    }else{
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        if(candyNum[0] == 0) {
            candyNum[0] = 1;
            for(int i = 1; i < ratings.length; i++) {
                if(ratings[i] > ratings[i - 1]) {
                    candyNum[i] = Math.max(candyNum[i - 1] + 1, candyNum[i]);
                }else if(ratings[i] == ratings[i - 1]) {
                    candyNum[i] = Math.max(1, candyNum[i]);
                }else{
                    break;
                }
            }
        }

        if(candyNum[ratings.length - 1] == 0) {
            candyNum[ratings.length - 1] = 1;
            for(int i = ratings.length - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1]) {
                    candyNum[i] = Math.max(candyNum[i], candyNum[i + 1] + 1);
                }else if(ratings[i] == ratings[i + 1]) {
                    candyNum[i] = Math.max(1,candyNum[i]);
                }else {
                    break;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < candyNum.length; i++) {
            sum += candyNum[i];
        }
        return sum;
    }
}