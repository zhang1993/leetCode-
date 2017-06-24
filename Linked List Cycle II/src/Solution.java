/**
 * Created by Shinelon on 2017/6/24.
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean flag = false;
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode temp;
        while(fast != null) {
            if(slow == fast) {
                slow = head;
                if(slow == fast)
                    return fast;
                if(!flag)
                    flag = true;
                else
                    return fast;
            }
            slow = slow.next;
            if(!flag) {
                if(fast.next != null) {
                    fast = fast.next.next;
                }else{
                    fast = fast.next;
                }
            }else{
                fast = fast.next;
            }


        }
        return null;
    }

}