import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shinelon on 2017/6/24.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(new Solution().wordBreak("catsanddog", wordDict));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }

        List<String> wordCutList = new LinkedList<>();

        if(!canBreak(s, wordDict))
            return wordCutList;

        findWord(s, "", set, wordCutList);
        return wordCutList;

    }

    public boolean canBreak(String s, List<String> wordDict) {
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

    public void findWord(String s,String cur, HashSet<String> set, List<String> list) {
        if(s.equals("")) {
            if(!cur.equals(""))
                list.add(cur);
        }
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if(set.contains(temp)) {
                if(cur.equals("")) {
                    findWord(s.substring(i + 1), cur + temp, set, list);
                }else{
                    findWord(s.substring(i + 1), cur + " " + temp, set, list);
                }
            }
        }
    }
}