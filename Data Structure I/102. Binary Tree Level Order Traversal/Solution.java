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
    
    private void traverseTree(TreeNode node, int level, List<Integer> lastExplored, List<List<Integer>> order){
        if (node == null)
            return;
        
        if (level > lastExplored.get(0)){
            order.add(new ArrayList<Integer>());
            lastExplored.set(0,level);
        }
        
        order.get(level).add(node.val);
        traverseTree(node.left, level+1,lastExplored,order);
        traverseTree(node.right, level+1,lastExplored,order);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        last.add(-1);
        traverseTree(root,0,last,order);
        
        return order;
    }
}