import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shinelon on 2017/6/15.
 */

    public class Solution {
        List<List<String>> result = new LinkedList<>();
        public static void main(String[] args) {
            LinkedList<String> list = new LinkedList<>();
            list.add("hot");
            list.add("dot");
            list.add("dog");
            list.add("lot");
            list.add("log");
            list.add("cog");

            System.out.print(new Solution().findLadders("hit","cog", list));
        }
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            HashMap<String, List<String>> adjancentMap = new HashMap<>();
            if(wordList.size() == 0)
                return result;
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            HashMap<String, Integer> stepMap = new HashMap<>();
            for(String s : wordList)
                stepMap.put(s, Integer.MAX_VALUE);
            stepMap.put(beginWord, 0);
            int step = 0;
            int minStep = Integer.MAX_VALUE;
            while(!queue.isEmpty()) {
                String temp = queue.poll();
                step = stepMap.get(temp) + 1;
                if(step <= minStep) {
                    for(int i = 0; i < temp.length(); i++) {

                        StringBuilder sb = new StringBuilder(temp);
                        for (char ch='a';  ch <= 'z'; ch++){
                            sb.setCharAt(i,ch);
                            String word = sb.toString();
                            if(stepMap.get(word) != null) {
                                if(step > stepMap.get(word))
                                    continue;
                                else if(step < stepMap.get(word)) {
                                    queue.add(word);
                                    stepMap.put(word, step);
                                }

                                if(adjancentMap.get(word) != null) {
                                    adjancentMap.get(word).add(temp);
                                }else{
                                    List<String> tempList = new LinkedList<>();
                                    tempList.add(temp);
                                    adjancentMap.put(word, tempList);
                                }
                                if(word.equals(endWord)) {
                                    minStep = step;
                                }

                            }
                        }
                    }
                }else{
                    break;
                }
            }
            backTrack(endWord, beginWord, adjancentMap, new LinkedList<String>());
            return result;
        }
        public boolean isNear(String s1, String s2) {
            int count = 0;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    count++;
                }
                if(count > 1)
                    return false;
            }
            if(count == 1)
                return true;
            return false;
        }
        public void backTrack(String end, String start, HashMap<String,List<String>> map,List<String> list) {
            if(end.equals(start)) {
                list.add(0,end);
                result.add(new LinkedList(list));
                list.remove(0);
                return;
            }
            list.add(0, end);
            if(map.get(end) != null) {
                for(String temp : map.get(end)) {
                    backTrack(temp, start, map, list);
                }
            }
            list.remove(0);
        }
    }