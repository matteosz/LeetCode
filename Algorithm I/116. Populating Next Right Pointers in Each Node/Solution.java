/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        connect_recursive(root,null);
        return root;
    }
    void connect_recursive(Node link, Node next){
        if (link == null)
            return;
        
        link.next = next;
        
        connect_recursive(link.left,link.right);
        connect_recursive(link.right, link.next==null? null : link.next.left);
        
    }

}