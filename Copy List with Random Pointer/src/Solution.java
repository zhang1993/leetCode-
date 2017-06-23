/**
 * Created by Shinelon on 2017/6/23.
 */

class RandomListNode {
    int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode rNode = head;
        RandomListNode temp;
        while(rNode != null) {
            temp = new RandomListNode(rNode.label);
            temp.next = rNode.next;
            rNode.next = temp;
            rNode = temp.next;
        }

        rNode = head;
        while(rNode != null) {
            rNode.next.random = rNode.random == null ? null : rNode.random.next;
            rNode = rNode.next.next;
        }

        RandomListNode rNode1 = head.next;
        RandomListNode rNode2 = head;
        RandomListNode newHead = rNode1;
        while(rNode1.next != null) {
            temp = rNode1.next;
            rNode2.next = temp;
            rNode2 = temp;
            rNode1.next = rNode1.next.next;
            rNode1 = rNode1.next;

        }
        rNode2.next = null;
        return newHead;
    }
}