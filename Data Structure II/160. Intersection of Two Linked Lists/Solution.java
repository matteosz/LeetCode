/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 1, lenB = 1, common = 0;
        ListNode a = headA, b = headB;
        for (;a.next != null || b.next != null; a = a.next==null?a:a.next, b = b.next==null? b:b.next) {
            if (a.next!=null) lenA++;
            if (b.next!=null) lenB++;
            if (a!=b && (a.next==null || b.next==null)) common++;
        }
        
        for (int i=0; i<common; i++) {
            headA = lenA>lenB? headA.next : headA;
            headB = lenB>lenA? headB.next : headB;
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    } 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
    
        return a;
    } 
}