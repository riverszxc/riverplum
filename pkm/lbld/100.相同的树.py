#
# @lc app=leetcode.cn id=100 lang=python3
#
# [100] 相同的树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        def traverse(p, q):
            if p is None and q is None:
                return True
            elif p and q and p.val==q.val:
                return traverse(p.left, q.left) and traverse(p.right, q.right)
            else:
                return False
        return traverse(p, q)
# @lc code=end

