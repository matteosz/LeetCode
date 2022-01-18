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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int direction = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null)
            return ans;
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            List<Integer> curr = new ArrayList<>();
            int s = queue.size();
            
            for (int i=0; i<s; i++) {
                
                TreeNode x = queue.remove();
                curr.add(x.val);
                
                if (x.left != null)
                    queue.offer(x.left);
                if (x.right != null)
                    queue.offer(x.right);
            }
            
            if (direction < 0)
                Collections.reverse(curr);
            
            ans.add(curr);
            
            direction *= -1;
        }
        
        return ans;
    }
}