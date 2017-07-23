import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shinelon on 2017/7/23.
 */
 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result = result + String.valueOf(root.val) + ",";
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();

            if(tmp.left == null)
                result = result + "null" +",";
            else {
                result = result + String.valueOf(tmp.left.val) + ",";
                queue.add(tmp.left);
            }
            if(tmp.right == null)
                result = result + "null" +",";
            else {
                result = result + String.valueOf(tmp.right.val) + ",";
                queue.add(tmp.right);
            }
        }
        return result.substring(0,result.length() - 1);
        // if(result.charAt(result.length() - 1))
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        int index = 1;
        while(index < nodes.length) {
            TreeNode tmp = queue.poll();
            if(!nodes[index].equals("null")) {
                TreeNode t = new TreeNode(Integer.valueOf(nodes[index]));
                tmp.left = t;
                queue.add(t);
            }
            if(!nodes[index + 1].equals("null")) {
                TreeNode t = new TreeNode(Integer.valueOf(nodes[index + 1]));
                tmp.right = t;
                queue.add(t);
            }
            index = index + 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));