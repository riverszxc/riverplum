#
# @lc app=leetcode.cn id=404 lang=python3
#
# [404] 左叶子之和
#
# https://leetcode.cn/problems/sum-of-left-leaves/description/
#
# algorithms
# Easy (62.82%)
# Likes:    710
# Dislikes: 0
# Total Accepted:    302.2K
# Total Submissions: 480.9K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定二叉树的根节点 root ，返回所有左叶子之和。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入: root = [3,9,20,null,null,15,7] 
# 输出: 24 
# 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
# 
# 
# 示例 2:
# 
# 
# 输入: root = [1]
# 输出: 0
# 
# 
# 
# 
# 提示:
# 
# 
# 节点数在 [1, 1000] 范围内
# -1000 <= Node.val <= 1000
# 
# 
# 
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
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        res = 0
        def traverse(root):
            nonlocal res
            if not root:
                return
            if root.left:
                if not root.left.left and not root.left.right:
                    res += root.left.val
            traverse(root.left)
            traverse(root.right)
        traverse(root)
        return res
# @lc code=end

