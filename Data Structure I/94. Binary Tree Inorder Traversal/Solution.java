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
    
    private void traverse(TreeNode root, List<Integer> in){
        if (root == null)
            return;
        traverse(root.left,in);
        in.add(root.val);
        traverse(root.right,in);
    }
    /* Recursive solution */
    public List<Integer> inorderTraversal- Stack(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        traverse(root,in);
        return in;
    }
    /* Iterative solution - Stack*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode x = root;
        
        while (x != null || !stack.isEmpty()){
            while (x != null){
                stack.push(x);
                x = x.left;
            }
            x = stack.pop();
            in.add(x.val);
            x = x.right;
        }
        
        return in;
    }
    /* Morris Traversal - O(1) in space */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}