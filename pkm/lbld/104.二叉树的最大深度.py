#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#
# https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
#
# algorithms
# Easy (77.10%)
# Likes:    1396
# Dislikes: 0
# Total Accepted:    859.6K
# Total Submissions: 1.1M
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最大深度。
# 
# 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
# 
# 说明: 叶子节点是指没有子节点的节点。
# 
# 示例：
# 给定二叉树 [3,9,20,null,null,15,7]，
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# 返回它的最大深度 3 。
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        res = 0
        def traverse(root, depth):
            if not root:
                return
            nonlocal res
            res = max(res, depth)
            traverse(root.left, depth + 1)
            traverse(root.right, depth + 1)
        traverse(root, 1)
        return res
# @lc code=end

