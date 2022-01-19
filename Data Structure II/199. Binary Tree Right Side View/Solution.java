/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root,ans,0);
        return ans;
    }
    
    private void helper(TreeNode node, List<Integer> ans, int lev) {
        
        if (node == null)
            return;
        
        if (ans.size() <= lev)
            ans.add(node.val);
        else ans.set(lev,node.val);
    
        helper(node.left,ans,lev+1);
        helper(node.right,ans,lev+1);
    }
}