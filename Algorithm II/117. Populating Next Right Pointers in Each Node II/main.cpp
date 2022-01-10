/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    /* Using stack - O(N) space */
    Node* connect2(Node* root) {
        if (!root) return root;
        stack<Node*> s;
        s.push(root);
        while (!s.empty()){
            Node* x = s.top();s.pop();
            Node *l = x->left, *r = x->right, *tmp = x->next, *next = nullptr;
            while (tmp != nullptr && next == nullptr) {
                next = tmp->left? tmp->left : tmp->right;
                tmp = tmp->next;
            }
            if (l != nullptr){
                l->next = x->right? x->right : next;
                s.push(l);
            }
            if (r != nullptr){
                r->next = next;
                s.push(r);
            }
        }
        return root;
    }
    /* Using O(1) space - level based approach */
    Node* connect(Node* root) {
        Node *curr = root;
        
        while (curr) {
            Node *head = nullptr, *prev = nullptr;  
            
            while (curr) { //visit all nodes on a level assigning next
                            
                if (curr->left){
                    if (prev)
                        prev->next = curr->left;
                    else head = curr->left;//no prev means the node is the first of the level
                    
                    prev = curr->left;
                }
                if (curr->right){
                    if (prev)
                        prev->next = curr->right;
                    else head = curr->right;
                    
                    prev = curr->right;
                }
                curr = curr->next;
            }
        
            curr = head; //next level
        }
        return root;
    }
};