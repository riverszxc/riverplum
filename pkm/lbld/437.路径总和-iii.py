#
# @lc app=leetcode.cn id=437 lang=python3
#
# [437] 路径总和 III
#
# https://leetcode.cn/problems/path-sum-iii/description/
#
# algorithms
# Medium (54.11%)
# Likes:    1442
# Dislikes: 0
# Total Accepted:    189.2K
# Total Submissions: 349.8K
# Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
#
# 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
# 
# 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
# 输出：3
# 解释：和等于 8 的路径有 3 条，如图所示。
# 
# 
# 示例 2：
# 
# 
# 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
# 输出：3
# 
# 
# 
# 
# 提示:
# 
# 
# 二叉树的节点个数的范围是 [0,1000]
# -10^9  
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
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        res = 0
        def traverse(root):
            if not root:
                return
            traverse2(root, targetSum)
            traverse(root.left)
            traverse(root.right)
        def traverse2(root, sum):
            if not root:
                return
            nonlocal res
            if sum == root.val:
                res += 1
            traverse2(root.left, sum - root.val)
            traverse2(root.right, sum - root.val)

        traverse(root)
        return res
# @lc code=end

