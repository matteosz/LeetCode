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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int n = 0;
        for (ListNode x = head; x != null; x = x.next, n++);
        
        ListNode sentinel = new ListNode(0,head), prev = sentinel, curr = head;
        for (int i=0; i<n/k; i++) { //cluster of nodes to reverse
            
            for (int j=1; j<k; j++) {
                ListNode next = curr.next.next;
                curr.next.next = prev.next;
                prev.next = curr.next;
                curr.next = next;
            }
            
            prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}