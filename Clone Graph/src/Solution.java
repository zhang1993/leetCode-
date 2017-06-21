import java.util.*;

/**
 * Created by Shinelon on 2017/6/21.
 */

  class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()) {
            UndirectedGraphNode tempNode = queue.poll();
            for(UndirectedGraphNode neighborNode : tempNode.neighbors) {
                if(map.get(neighborNode.label) != null) {
                    UndirectedGraphNode nextNode = map.get(neighborNode.label);
                    map.get(tempNode.label).neighbors.add(nextNode);
                }else{
                    UndirectedGraphNode nextNode =  new UndirectedGraphNode(neighborNode.label);
                    map.put(neighborNode.label, nextNode);
                    queue.add(neighborNode);
                    map.get(tempNode.label).neighbors.add(nextNode);
                }
            }
        }
        return map.get(node.label);

    }
}