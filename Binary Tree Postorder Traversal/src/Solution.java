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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return list;
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while(!stack.isEmpty()) {
            cur = stack.peek();
            if(cur.right == pre || cur.right == null) {
                list.add(cur.val);
                pre = cur;
                stack.pop();
            }else{
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return list;
    }
}