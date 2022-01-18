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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {
        if (rp >= preorder.length || ri >= inorder.length || lp > rp || li > ri) 
            return null;
        
        TreeNode x = new TreeNode(preorder[lp]);
        
        int n = 0;
        for (int i=li; i <= ri; i++, n++)
            if (inorder[i] == preorder[lp])
                break;
        
        x.left = helper(preorder,inorder,lp+1,lp+n,li,li+n-1);

        x.right = helper(preorder,inorder,lp+n+1,rp,li+n+1,ri);
        
        return x;
    }
}