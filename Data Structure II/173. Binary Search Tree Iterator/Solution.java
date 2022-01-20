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
class BSTIterator {

    class Node {
        Node next = null;
        int val = -1;
        Node(){}
        Node (int val) {
            this.val = val;
        }
    }
    
    Node head = new Node();
    
    public BSTIterator(TreeNode root) {
        link(root,head);
    }
    
    private Node link(TreeNode node, Node list) {
        if (node == null) return list;
        
        list = link(node.left,list);
        list.next = new Node(node.val);
        list = link(node.right,list.next);

        return list;
    }
    
    public int next() {
        head = head.next;
        return head.val;
    }
    
    public boolean hasNext() {
        return head.next != null;
    }
}
/* Stack solution to use O(h) in memory */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */