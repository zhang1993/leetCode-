/**
 * Created by Shinelon on 2017/6/10.
 */


 class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n)
            return head;

        ListNode temp = head;
        int currentPos = 0;
        ListNode junctionPre1 = null,junctionPre2 = null;
        ListNode junctionAfter1 = null,junctionAfter2 = null;
        ListNode after = null;
        ListNode pre = null;
        while(temp != null) {
            currentPos++;
            if(currentPos > n)
                break;
            if(currentPos == m) {
                junctionPre1 = pre;
                junctionAfter1 = temp;
            }

            if(currentPos == n) {
                junctionPre2 = temp;
                junctionAfter2 = temp.next;
            }

            if(currentPos > m && currentPos <= n) {
                after = temp.next;
                temp.next = pre;
            }

            pre = temp;
            temp = after != null ? after : temp.next;

        }
        if(m != 1) {
            junctionPre1.next = junctionPre2;
            junctionAfter1.next = junctionAfter2;
            return head;
        }else {
            junctionAfter1.next = junctionAfter2;
            return junctionPre2;
        }
    }
}