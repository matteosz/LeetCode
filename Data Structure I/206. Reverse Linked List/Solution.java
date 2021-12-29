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
    /* Recursive solution */
    public ListNode reverseList(ListNode head) {
        return recursive(head, null);
    }
    ListNode recursive(ListNode curr, ListNode prev){
        if (curr == null)
            return prev;
        ListNode x = curr;
        curr = recursive(curr.next,curr);
        x.next = prev;
        
        return curr;
    }
    /* Iterative solution */
    public ListNode reverseList(ListNode head) {
        ListNode tmp = null, prev = null;
        for (ListNode curr = head; curr != null ; prev = curr, curr = tmp){
            tmp = curr.next;
            curr.next = prev;
            
        }
        
        return prev;
    }
}