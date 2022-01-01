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
    /* Recursive solution */
    private boolean traverse(TreeNode leftNode, TreeNode rightNode){
        if (leftNode == null || rightNode == null)
            return leftNode == rightNode;
        
        if (leftNode.val == rightNode.val)
            return traverse(leftNode.left,rightNode.right) && traverse(leftNode.right, rightNode.left);
        else return false;
    }
    
    /* Iterative solution */
    public boolean isSymmetric(TreeNode root) {
        //return traverse(root,root); Recursion
        
        if (root == null) return true;
        
        TreeNode leftMirror = root.left, rightMirror = root.right;
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(leftMirror);stack.push(rightMirror);
        
        while (!stack.isEmpty()){
            rightMirror = stack.pop();
            leftMirror = stack.pop();
            
            if (rightMirror == null && leftMirror == null) continue;
            
            if (rightMirror == null || leftMirror == null || rightMirror.val != leftMirror.val)
                return false;
            
            stack.push(leftMirror.left);stack.push(rightMirror.right);
            stack.push(leftMirror.right);stack.push(rightMirror.left);
        }
        
        return true;
    }
}