/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /* No sentinel solution */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null, newTail = null;
               
        while (head != null){
            int val = head.val;
            boolean distinct = true;
            while (head.next != null && head.next.val==val) {
                head = head.next;
                distinct = false;
            }
                
            if (newHead == null || newHead.val == val){
                newHead = distinct? head : head.next;
                newTail = newHead;
            }
            else {
                newTail = distinct? head : newTail;
                if (!distinct) newTail.next = head.next;
            }
            
            head = head.next;
        }
        
        return newHead;
    }
}