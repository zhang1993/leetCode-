/**
 * Created by Shinelon on 2017/6/26.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode cur = headA;
        while(cur != null) {
            cur = cur.next;
            lengthA++;
        }
        cur = headB;
        while(cur != null) {
            cur = cur.next;
            lengthB++;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;
        while(pointA != pointB) {
            if(lengthA > lengthB) {
                pointA = pointA.next;
                lengthA--;
            }else if(lengthB > lengthA) {
                pointB = pointB.next;
                lengthB--;
            }else{
                pointA = pointA.next;
                pointB = pointB.next;
            }
        }
        return pointA;
    }
}