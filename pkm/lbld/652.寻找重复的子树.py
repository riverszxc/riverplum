#
# @lc app=leetcode.cn id=652 lang=python3
#
# [652] 寻找重复的子树
#
# https://leetcode.cn/problems/find-duplicate-subtrees/description/
#
# algorithms
# Medium (58.77%)
# Likes:    461
# Dislikes: 0
# Total Accepted:    59.2K
# Total Submissions: 100.6K
# Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
#
# 给定一棵二叉树 root，返回所有重复的子树。
# 
# 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
# 
# 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入：root = [1,2,3,4,null,2,4,null,null,4]
# 输出：[[2,4],[4]]
# 
# 示例 2：
# 
# 
# 
# 
# 输入：root = [2,1,1]
# 输出：[[1]]
# 
# 示例 3：
# 
# 
# 
# 
# 输入：root = [2,2,2,3,null,3,null]
# 输出：[[2,3],[3]]
# 
# 
# 
# 提示：
# 
# 
# 树中的结点数在[1,10^4]范围内。
# -200 <= Node.val <= 200
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
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        res = []
        mem = {}
        def traverse(root):
            if not root:
                return '#'
            l = traverse(root.left)
            r = traverse(root.right)
            t = ','.join([str(root.val), l, r])
            mem[t] = mem.get(t, 0) + 1
            if mem[t] == 2:
                res.append(root)
            return t
        traverse(root)
        return res
#       2
#     1   11
#   11   1
# @lc code=end

