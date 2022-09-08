#
# @lc app=leetcode.cn id=257 lang=python3
#
# [257] 二叉树的所有路径
#
# https://leetcode.cn/problems/binary-tree-paths/description/
#
# algorithms
# Easy (70.21%)
# Likes:    803
# Dislikes: 0
# Total Accepted:    242.2K
# Total Submissions: 345K
# Testcase Example:  '[1,2,3,null,5]'
#
# 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
# 
# 叶子节点 是指没有子节点的节点。
# 
# 
# 示例 1：
# 
# 
# 输入：root = [1,2,3,null,5]
# 输出：["1->2->5","1->3"]
# 
# 
# 示例 2：
# 
# 
# 输入：root = [1]
# 输出：["1"]
# 
# 
# 
# 
# 提示：
# 
# 
# 树中节点的数目在范围 [1, 100] 内
# -100 <= Node.val <= 100
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
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        def traverse(root):
            if not root:
                return
            nonlocal res
            nonlocal result
            res.append(root.val)
            if not root.left and not root.right:
                result.append('->'.join([str(x) for x in res]))
            traverse(root.left)
            traverse(root.right)
            res.pop()
        result = []
        res = []
        traverse(root)
        return result
# @lc code=end

