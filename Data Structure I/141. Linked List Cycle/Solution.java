/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /* O(N) time, O(N) space */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        for(ListNode x = head; x != null; x = x.next)
            if(!set.add(x))
                return true;
        
        return false;
    }
    /* O(N time, O(1) space */
    public boolean hasCycle(ListNode head) {
        ListNode walker = head, runner = head;
        //runner makes 2 step each time, walker just 1
        //if there's a loop they will meet
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) 
                return true;
        }

        return false;
    }
}