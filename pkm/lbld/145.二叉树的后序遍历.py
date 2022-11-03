#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    #     res = []
    #     if not root:
    #         return res
    #     def traverse(root):
    #         if not root:
    #             return
    #         traverse(root.left)
    #         traverse(root.right)
    #         res.append(root.val)
    #     traverse(root)
    #     return res
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res
        stack = []
        p = root
        prev = None
        while p or stack:
            while p:
                stack.append(p)
                p = p.left
            p = stack.pop()
            if not p.right or p.right == prev:
                res.append(p.val)
                prev = p
                p = None
            else:
                stack.append(p)
                p = p.right
        return res
# @lc code=end

