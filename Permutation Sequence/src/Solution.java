/**
 * Created by Shinelon on 2017/5/30.
 */
import java.util.*;
//会TLE的方法
//public class Solution {
//    int count = 0;
//    boolean signal = true;
//    public String getPermutation(int n, int k) {
//        LinkedList<Integer> list = new LinkedList<>();
//        permutationKthList(list, n, k);
//        String result = "";
//        for(Integer num : list)
//            result += num.toString();
//        return result;
//    }
//
//    public void permutationKthList(List<Integer> list, int n, int k) {
//        for(int i = 1; i <= n; i++) {
//
//            boolean flag = true;
//            for(Integer temp : list) {
//                if(temp == i)
//                    flag = false;
//            }
//            if(flag) {
//                list.add(i);
//                if(list.size() == n) {
//                    count++;
//                    if(count == k)
//                        signal = false;
//                }else {
//                    permutationKthList(list, n , k);
//                }
//                if(signal)
//                    list.remove(list.size() - 1);
//            }
//            if(!signal)
//                return;
//        }
//
//    }
//}
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(5,2));
    }
    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        int initNum = 1;

        for(int i = 1; i <= n; i++) {
            initNum *= i;
        }
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = n; i >= 1; i--) {
            initNum /= i;
            Integer temp = list.get((k - 1) / initNum);
            result.add(new Integer(temp));
            k = k - (k - 1) / initNum * initNum;
            list.remove(temp);
        }
        String resultString = "";
        for(Integer num : result)
            resultString += num.toString();
        return resultString;
    }

}