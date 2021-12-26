/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    
    ListNode* crossAndRemove(ListNode* node, int* len, int n){
        if (node->next == nullptr)
            return n==1? nullptr : node;
        int pos = (*len)++;
        node->next = crossAndRemove(node->next,len,n);
        if ( pos == *len - n + 1 )
            return node->next;
        return node;
    }
    
public:
/* recursive approach */
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int len = 1;
        return crossAndRemove(head, &len, n);
    }
/* Fast and Slow pointers: make fast advance first of n elements than slow starts. When fast has ended slow will point the element to be deleted */
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *fast = head, *slow = head;
        for (int i = 0; i < n; i++) fast = fast->next;
        if (!fast) return head->next;
        while (fast->next) fast = fast->next, slow = slow->next;
        slow->next = slow->next->next;
        return head;
    }

};