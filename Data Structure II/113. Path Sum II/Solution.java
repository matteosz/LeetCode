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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        helper(ans,new LinkedList<Integer>(),root,targetSum);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, LinkedList<Integer> path, TreeNode node, int target) {
        
        if (node == null)
            return;
        
        int val = node.val;
        path.add(val);
        
        if (isLeaf(node)) {
            if (target == val)
                ans.add(new LinkedList<>(path));
        }
        else {
            helper(ans,path,node.left,target-val);
            helper(ans,path,node.right,target-val);
        }
        
        path.removeLast();
    }
    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}