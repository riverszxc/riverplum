#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#
# https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
#
# algorithms
# Easy (51.00%)
# Likes:    830
# Dislikes: 0
# Total Accepted:    449.3K
# Total Submissions: 880.9K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最小深度。
# 
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
# 
# 说明：叶子节点是指没有子节点的节点。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root = [3,9,20,null,null,15,7]
# 输出：2
# 
# 
# 示例 2：
# 
# 
# 输入：root = [2,null,3,null,4,null,5,null,6]
# 输出：5
# 
# 
# 
# 
# 提示：
# 
# 
# 树中节点数的范围在 [0, 10^5] 内
# -1000 
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
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        q = [root]
        depth = 0
        while q:
            depth += 1
            sz = len(q)
            for i in range(sz):
                t = q.pop(0)
                if not t.left and not t.right:
                    return depth
                if t.left:
                    q.append(t.left)
                if t.right:
                    q.append(t.right)
# @lc code=end

