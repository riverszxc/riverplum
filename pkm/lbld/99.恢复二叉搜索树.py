#
# @lc app=leetcode.cn id=99 lang=python3
#
# [99] 恢复二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        pre = None
        first = None
        second = None
        def traverse(root):
            nonlocal pre, first, second
            if not root:
                return
            traverse(root.left)
            if not pre:
                pre = root
            else:
                if pre.val > root.val:
                    first = pre if not first else first
                    second = root
                pre = root
            traverse(root.right)
        traverse(root)
        if first and second:
            first.val, second.val = second.val, first.val
# @lc code=end

