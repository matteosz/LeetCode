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
    /* O(N) in space */
    void reorderList(ListNode* head) {
        vector<ListNode*> nodes;
        for (ListNode *x = head; x != nullptr; x = x->next)
            nodes.push_back(x);
        int n = nodes.size();
        for (int i=0; i<n/2; i++) {
            nodes[i]->next = nodes[n-i-1];
            nodes[n-i-1]->next = nodes[i+1];
        }
        nodes[n/2]->next = nullptr;
    }
    /* O(1) in space */
    void reorderList(ListNode* head) {
        if (head->next == nullptr) return;
        
        ListNode *walker = head, *runner = head;
        while (runner->next && runner->next->next) {
            walker = walker->next;
            runner = runner->next->next;
        }
        ListNode *mid = walker->next;
        walker->next = nullptr;

        ListNode *p = mid, *q = mid->next, *pp = NULL, *qq = NULL;
        mid->next = nullptr;//last element in the reversed half list
        while (q != nullptr) {
            pp = p;
            p = q;
            q = q->next;
            p->next = pp;
        }
        mid = p;

        p = head;
        q = mid;
        while (q != nullptr) {
            pp = p; 
            qq = q;
            p = p->next; 
            q = q->next;
            pp->next = qq; 
            qq->next = p;
        }
    }
};