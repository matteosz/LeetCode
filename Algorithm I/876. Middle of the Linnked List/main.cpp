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
    
    ListNode* cross(ListNode* x, int* n){
        if(x->next == nullptr)
            return x;
        
        int i = (*n)++;
        ListNode* y = cross(x->next,n);
        if (i == ceil((*n)/(float)2))
            y = x;
        return y;
    }
    
public:
    ListNode* middleNode(ListNode* head) {
        int n = 0;
        return cross(head, &n);
    }
/* Fast and Slow Pointers */
    ListNode* middleNode(ListNode* head) {

        ListNode* fast = head;
        ListNode* slow = fast;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;        
    }
};