import java.util.HashMap;

/**
 * Created by Shinelon on 2017/6/27.
 */
public class LRUCache {
    int size;
    int curSize;
    ListNode tail = null;
    ListNode head = null;
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, ListNode> set = new HashMap<>();
    public LRUCache(int capacity) {

        size = capacity;
        curSize = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode temp = set.get(key);
            if(temp == tail)
                return map.get(key);
            if(temp == head) {
                head = temp.next;
                head.pre = null;
                tail.next = temp;
                temp.pre = tail;
                tail = temp;
                temp.next = null;
                return map.get(key);
            }
            if(temp.pre == null) {
                System.out.println(temp.val);
                System.out.print("error");
            }
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            tail.next = temp;
            temp.pre = tail;
            temp.next = null;
            tail = temp;
            return map.get(key);
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(curSize < size) {

            map.put(key, value);
            if(set.containsKey(key)) {
                ListNode temp = set.get(key);
                if(temp == tail){

                }else if(temp == head) {
                    head = temp.next;
                    head.pre = null;
                    tail.next = temp;
                    temp.pre = tail;
                    tail = temp;
                    temp.next = null;
                }else {
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                    tail.next = temp;
                    temp.pre = tail;
                    temp.next = null;
                    tail = temp;
                }
                map.put(key, value);
            }else {
                curSize++;
                ListNode temp = new ListNode(key);
                temp.pre = tail;
                if(tail != null)
                    tail.next = temp;
                tail = temp;
                temp.next = null;
                if(head == null)
                    head = temp;
                set.put(temp.val, temp);
            }
        }else{
            if(set.containsKey(key)) {
                ListNode temp = set.get(key);
                if(temp == tail){

                }else if(temp == head) {
                    head = temp.next;
                    head.pre = null;
                    tail.next = temp;
                    temp.pre = tail;
                    tail = temp;
                    temp.next = null;
                }else {
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                    tail.next = temp;
                    temp.pre = tail;
                    temp.next = null;
                    tail = temp;
                }
                map.put(key, value);
            }else {
                map.remove(new Integer(head.val));
                set.remove(new Integer(head.val));
                map.put(key, value);
                head = head.next;
                if(head != null)
                    head.pre = null;
                ListNode temp = new ListNode(key);
                set.put(temp.val,temp);
                temp.pre = tail;
                if(tail != null)
                    tail.next = temp;
                tail = temp;
                temp.next = null;
                if(head == null)
                    head = temp;
            }
        }
    }

    class ListNode{
        ListNode next;
        ListNode pre;
        Integer val;
        ListNode(Integer a) {
            val = a;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */