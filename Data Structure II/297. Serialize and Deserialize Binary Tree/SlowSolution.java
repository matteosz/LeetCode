import java.util.*;
public class Codec {

    class Pair {
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<Pair> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int lv = 1;

        stack.offer(new Pair(root,0));
        while (!stack.isEmpty()) {
            int s = stack.size(), curr = 0;

            for (int i=0; i<s; i++) {
                Pair x = stack.remove();
                while (x.pos > curr) {
                    sb.append("N%");
                    curr++;
                }
                sb.append(Integer.toString(x.node.val)).append('%');
                curr++;
                
                if (x.node.left != null)
                    stack.offer(new Pair(x.node.left,x.pos*2));
                if (x.node.right != null)
                    stack.offer(new Pair(x.node.right,x.pos*2 + 1));
            }
            while (curr < lv) {
                sb.append("N%");
                curr++;
            }

            lv *= 2;
        }
        
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] nodes = data.split("%");
        int n = nodes.length;
        TreeNode[] tree = new TreeNode[n];
        
        for (int i=0; i < n; i++)
            tree[i] = nodes[i].equals("N")? null : new TreeNode(Integer.parseInt(nodes[i]));
        
        for (int i=0; i < n/2; i++) 
            if (tree[i] != null) {
                tree[i].left = tree[2*i+1];
                tree[i].right = tree[2*i+2];
        }
        
        return tree[0];
    }

    public static void main(String[] argv){
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode root = new TreeNode(1);
        root.left = two;root.right = three;
        three.left = four;three.right = five;
        four.left = six;four.right = seven;

        Codec c = new Codec();
        String s = c.serialize(root);
        TreeNode x = c.deserialize(s);
        boolean t = x == root;
        System.err.println(t);
    }
}