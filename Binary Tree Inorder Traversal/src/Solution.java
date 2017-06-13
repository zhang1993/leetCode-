/**
 * Created by Shinelon on 2017/6/13.
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



class TreeNode {
      int val;
    TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        List<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null)
                cur = temp.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return list;
    }
}