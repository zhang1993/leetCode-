import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shinelon on 2017/7/6.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int depth = maxDepth(root);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;
        result.add(root.val);
        stack.push(root);
        TreeNode pre = null;
        int flag  = 0;
        while(stack.size() < depth) {
            TreeNode temp = stack.peek();
            if(temp.right != null && flag == 0) {
                stack.push(temp.right);
                if(stack.size() > result.size()){
                    result.add(temp.right.val);
                }

            }else if(temp.left != null && flag != 2) {
                stack.push(temp.left);
                if(stack.size() > result.size()) {
                    result.add(temp.left.val);
                }
                flag = 0;

            }else{
                TreeNode t = stack.pop();
                if(stack.peek().left == t)
                    flag = 2;
                else
                    flag = 1;
            }
        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}