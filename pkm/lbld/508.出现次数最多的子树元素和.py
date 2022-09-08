#
# @lc app=leetcode.cn id=508 lang=python3
#
# [508] 出现次数最多的子树元素和
#
# https://leetcode.cn/problems/most-frequent-subtree-sum/description/
#
# algorithms
# Medium (75.36%)
# Likes:    206
# Dislikes: 0
# Total Accepted:    40.4K
# Total Submissions: 53.6K
# Testcase Example:  '[5,2,-3]'
#
# 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
# 
# 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入: root = [5,2,-3]
# 输出: [2,-3,4]
# 
# 
# 示例 2：
# 
# 
# 
# 
# 输入: root = [5,2,-5]
# 输出: [2]
# 
# 
# 
# 
# 提示:
# 
# 
# 节点数在 [1, 10^4] 范围内
# -10^5 <= Node.val <= 10^5
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
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        sums = {}
        def subsum(root):
            if not root:
                return 0
            nonlocal sums
            leftsum = subsum(root.left)
            rightsum = subsum(root.right)
            x = root.val + leftsum + rightsum
            sums[x] = sums.get(x, 0) + 1
            return x
        subsum(root)
        maxv = max(sums.values())
        return [x for x in sums if sums[x] == maxv]

# @lc code=end

