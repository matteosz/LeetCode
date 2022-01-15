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
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode *sentinel = new ListNode(0,head), *curr = sentinel;
        
        while (head && head->next) {
            ListNode *tmp = head->next->next;
            head->next->next = head;
            curr->next = head->next;
            curr = head;
            head = tmp;            
        }
        
        curr->next = head;
        
        return sentinel->next;
    }
};