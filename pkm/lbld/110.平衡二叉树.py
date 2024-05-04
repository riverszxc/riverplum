#
# @lc app=leetcode.cn id=110 lang=python3
#
# [110] 平衡二叉树
#
# https://leetcode.cn/problems/balanced-binary-tree/description/
#
# algorithms
# Easy (58.37%)
# Likes:    1503
# Dislikes: 0
# Total Accepted:    608.3K
# Total Submissions: 1M
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，判断它是否是 平衡二叉树  
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root = [3,9,20,null,null,15,7]
# 输出：true
# 
# 
# 示例 2：
# 
# 
# 输入：root = [1,2,2,3,3,null,null,4,4]
# 输出：false
# 
# 
# 示例 3：
# 
# 
# 输入：root = []
# 输出：true
# 
# 
# 
# 
# 提示：
# 
# 
# 树中的节点数在范围 [0, 5000] 内
# -10^4 <= Node.val <= 10^4
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
    # def isBalanced(self, root: Optional[TreeNode]) -> bool:
    #     def depth(root):
    #         if not root:
    #             return 0
    #         return 1 + max(depth(root.left), depth(root.right))
    #     if not root:
    #         return True
    #     left = depth(root.left)
    #     right = depth(root.right)
    #     return abs(left-right)<2 and self.isBalanced(root.left) and self.isBalanced(root.right)
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def depth(root):
            if not root:
                return 0
            left = depth(root.left)
            right = depth(root.right)
            if left == -1 or right == -1 or abs(left-right)>1:
                return -1
            return 1 + max(left, right)
        return depth(root) >= 0
# @lc code=end

#        1
#      2    2
#   3          3
# 4               4