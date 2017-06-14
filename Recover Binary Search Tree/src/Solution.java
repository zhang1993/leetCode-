import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        new Solution().recoverTree(root);
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode pre = null;
        boolean flag = false;
        TreeNode temp1 = null,temp2 = null;
        while(!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if(pre == null) {
                pre = t;
                flag = true;
            }else if(flag && t.val > pre.val) {
                pre = t;
            }else {
                if(temp1 == null) {
                    temp1 = pre;
                    temp2 = t;
                    pre = t;
                }else{
                    temp2 = t;
                    pre = t;
                    break;
                }
            }
            if(t.right != null) {
                cur = t.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        int num = temp1.val;
        temp1.val = temp2.val;
        temp2.val = num;
    }
}