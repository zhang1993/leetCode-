/**
 * Created by Shinelon on 2017/6/8.
 */


class ListNode {
 int val;
     ListNode next;
    ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode pre = head;
        int size = 0;
        while(current != null) {
            size++;
            current = current.next;
        }
        current = head;
        while(current != null) {
            if(current.val < x) {
                if(pre.val >= x) {
                    int temp = current.val;
                    ListNode newNode = new ListNode(pre.val);
                    pre.val = temp;
                    ListNode afterNode = pre.next;
                    pre.next = newNode;
                    newNode.next = afterNode;
                    if(current.next != null) {
                        current.val = current.next.val;
                        current.next = current.next.next;
                    }else{
                        current = current.next;
                    }
                    pre = pre.next;
                }else {
                    pre = pre.next;
                    current = current.next;
                }

            }else{
                current = current.next;
            }
        }
        current = head;
        int count = 0;
        while(++count < size) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
}