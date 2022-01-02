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
    
    bool isLeaf(TreeNode* node){
        if (node->left == nullptr && node->right == nullptr)
            return true;
        return false;
    }
    
    bool helper(TreeNode* node, int currSum, int targetSum){
        if (node == nullptr) return false;
        
        currSum += node->val;
        
        if (isLeaf(node) &&  currSum==targetSum)
            return true;
        
        return helper(node->left,currSum,targetSum) || helper(node->right,currSum,targetSum);
    }
    
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (!root) return false;
        
        return helper(root,0,targetSum);
    }
};