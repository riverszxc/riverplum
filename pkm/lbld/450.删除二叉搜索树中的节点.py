#
# @lc app=leetcode.cn id=450 lang=python3
#
# [450] 删除二叉搜索树中的节点
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def getrightmin(root):
            while root.left:
                root = root.left
            return root

        if not root:
            return None
        if root.val == key:
            if not root.left and not root.right:
                return None
            if not root.left or not root.right:
                return root.left if root.left else root.right
            rightmin = getrightmin(root.right)
            root.right = self.deleteNode(root.right, rightmin.val)
            rightmin.left = root.left
            #wrong! root.right = self.deleteNode(root.right, rightmin.val)
            rightmin.right = root.right#self.deleteNode(root.right, rightmin.val)
            return rightmin
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        else:
            root.right = self.deleteNode(root.right, key)
        return root
            
# @lc code=end

