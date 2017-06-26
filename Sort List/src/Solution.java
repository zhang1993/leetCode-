/**
 * Created by Shinelon on 2017/6/26.
 */

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 =sortList(temp);
        return mergeList(node1, node2);
    }

    public ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(node1 != null && node2 != null) {
            if(node1.val > node2.val) {
                tail.next = node2;
                node2 = node2.next;
            }else{
                tail.next = node1;
                node1 = node1.next;
            }
            tail = tail.next;
        }
        if(node1 == null)
            tail.next = node2;
        if(node2 == null)
            tail.next = node1;
        return dummy.next;
    }
}
