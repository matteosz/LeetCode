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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        for (ListNode curr = head; curr != null; curr = curr.next)
            if (prev != null && prev.val == curr.val){
                prev.next = curr.next;
            }
            else prev = curr;
            
        
        return head;
    }
}