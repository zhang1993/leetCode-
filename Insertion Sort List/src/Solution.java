/**
 * Created by Shinelon on 2017/6/25.
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head.next;
        ListNode next;
        ListNode guideNode = new ListNode(0);
        guideNode.next = head;
        head.next = null;
        while(cur != null) {
            next = cur.next;
            ListNode temp = guideNode;
            while(temp.next != null) {
                if(cur.val >= temp.next.val) {
                    temp = temp.next;
                    if(temp.next == null) {
                        temp.next = cur;
                        cur.next = null;
                    }
                }else{
                    cur.next = temp.next;
                    temp.next = cur;
                    break;
                }
            }
            cur = next;
        }
        return guideNode.next;
    }
}