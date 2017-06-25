import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shinelon on 2017/6/25.
 */

class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list  = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return list;
        TreeNode cur = root;
        while(cur != null) {
            list.add(cur.val);
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()) {
            cur = stack.pop();
            cur = cur.right;
            while(cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
        }
        return list;
    }
}