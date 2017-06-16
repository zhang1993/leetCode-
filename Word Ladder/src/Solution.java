import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shinelon on 2017/6/16.
 */
public class Solution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.print(new Solution().ladderLength("hit","cog", list));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int curLayerNum = 1;
        int curNum = 0;
        int nextNum = 0;
        int step = 1;
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> curSet = new HashSet<>();
        curSet.add(beginWord);
        while(!queue.isEmpty()) {
            curNum++;
            if(curNum == 1)
                step++;
            String word = queue.poll();
            for(int i = 0; i < beginWord.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, c);
                    String temp = sb.toString();
                    if(wordSet.contains(temp) && (!curSet.contains(temp))) {
                        nextNum++;
                        queue.add(temp);
                        curSet.add(temp);
                    }
                    if(temp.equals(endWord))
                        return step;
                }
            }
            if(curNum == curLayerNum) {
                curLayerNum = nextNum;
                nextNum = 0;
                curNum = 0;
            }
        }
        return 0;
    }
}