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
    
    private boolean find(TreeNode node, int k, HashSet<Integer> map){
        if (node == null)
            return false;
        if (map.contains(k-node.val))
            return true;
        map.add(node.val);
        
        return find(node.left,k,map) || find(node.right,k,map);
    }
    /* Pre-order traversal + HashSet, O(n) in space and memory */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();
        return find(root,k,map);
    }
}