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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1), curr = head;
        
        for (;l1 != null || l2 != null; l1 = (l1==null? l1 : l1.next), l2 = (l2==null? l2 : l2.next), curr = curr.next) {
            int val = carry + (l1!=null? l1.val : 0) + (l2!= null? l2.val : 0);
            carry = val / 10;
            curr.next = new ListNode(val % 10);
        }
        
        if (carry == 1)
            curr.next = new ListNode(1);
        
        return head.next;
    }
}