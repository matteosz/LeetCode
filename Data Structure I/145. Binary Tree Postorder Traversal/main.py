# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Iterative solution
    def postorderTraversal(self, root):
        traversal, stack = [], [(root, False)]
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    traversal.append(node.val)
                else:
                    # post-order
                    stack.append((node, True))
                    stack.append((node.right, False))
                    stack.append((node.left, False))

        return traversal
    # Recursive solution 
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        post = []
        self.traverse(root,post)
        return post
        
    def traverse(self, root, post):
        if root is None:
            return
        self.traverse(root.left,post)
        self.traverse(root.right,post)
        post.append(root.val)