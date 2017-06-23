import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shinelon on 2017/6/23.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new Solution().wordBreak("leetcode", list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }
        boolean[] dpArray = new boolean[s.length() + 1];
        dpArray[0] = true;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i ; j >= 0; j--) {
                if(dpArray[j] && set.contains(s.substring(j, i + 1))) {
                    dpArray[i + 1] = true;
                    break;
                }
            }
        }
        return dpArray[s.length()];
    }


}