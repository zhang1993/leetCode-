import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shinelon on 2017/6/20.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().partition("abbb"));
    }
    public List<List<String>> partition(String s) {
        boolean[][] dpArray = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dpArray[i][i] = true;
        }

        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < s.length() - i; j++) {
                if(s.charAt(j) == s.charAt(j + i)) {
                    if(i == 1) {
                        dpArray[j][j + i] = true;
                    }else{
                        dpArray[j][j + i] = dpArray[j + 1][j + i - 1];
                    }
                }
            }
        }
        List<List<String>> returnArray = new LinkedList<>();
        List<String> tempArray = new LinkedList<>();
        recursivePrint(tempArray, returnArray, 0, s, dpArray);
        return returnArray;
    }

    public void recursivePrint(List<String> tempArray, List<List<String>>  returnArray, int index, String s, boolean[][] dpArray) {
        if(index == s.length()) {
            returnArray.add(new LinkedList(tempArray));
        }
        for(int i = index; i < s.length(); i++) {
            if(dpArray[index][i]) {
                tempArray.add(s.substring(index, i + 1));
                recursivePrint(tempArray, returnArray, i + 1, s, dpArray);
                tempArray.remove(tempArray.size() - 1);
            }
        }
    }
}