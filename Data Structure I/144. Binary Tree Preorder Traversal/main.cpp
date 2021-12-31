/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    
    void traverse_pre(TreeNode* root, vector<int>& pre){
        if (root == nullptr)
            return;
        pre.push_back(root->val);
        traverse_pre(root->left,pre);
        traverse_pre(root->right,pre);
    }
    
public:
    /* Recursive solution */
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> preorder;
        
        traverse_pre(root,preorder);
        
        return preorder;
    }
    /* Iterative solution */
    vector<int> preorderTraversal(TreeNode* root) {
        stack<TreeNode*> s;
        vector<int> preorder;
        
        if (root == nullptr) return preorder;
        
        s.push(root);
        
        while (!s.empty()){
            TreeNode* x = s.top();s.pop();
            if (x == nullptr) continue;
            preorder.push_back(x->val);
            s.push(x->right);
            s.push(x->left);
        }
        return preorder;
    } 
};