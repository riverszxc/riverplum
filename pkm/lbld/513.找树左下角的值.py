#
# @lc app=leetcode.cn id=513 lang=python3
#
# [513] 找树左下角的值
#
# https://leetcode.cn/problems/find-bottom-left-tree-value/description/
#
# algorithms
# Medium (74.44%)
# Likes:    378
# Dislikes: 0
# Total Accepted:    138.2K
# Total Submissions: 185.7K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
# 
# 假设二叉树中至少有一个节点。
# 
# 
# 
# 示例 1:
# 
# 
# 
# 
# 输入: root = [2,1,3]
# 输出: 1
# 
# 
# 示例 2:
# 
# ⁠
# 
# 
# 输入: [1,2,3,4,null,5,6,null,null,7]
# 输出: 7
# 
# 
# 
# 
# 提示:
# 
# 
# 二叉树的节点个数的范围是 [1,10^4]
# -2^31  
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
    # def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
    #     max_depth = 0
    #     depth = 0
    #     x = None
    #     def traverse(root):
    #         if not root:
    #             return
    #         nonlocal max_depth
    #         nonlocal depth
    #         nonlocal x
    #         depth += 1
    #         if depth > max_depth:
    #             max_depth = depth
    #             x = root
    #         traverse(root.left)
    #         traverse(root.right)
    #         depth -= 1
    #     traverse(root)
    #     return x.val

    def findBottomLeftValue(self, root):
        x = None
        q = [root]
        while q:
            l = len(q)
            for i in range(l):
                tmp = q.pop(0)
                if i == 0:
                    x = tmp.val
                if tmp.left:
                    q.append(tmp.left)
                if tmp.right:
                    q.append(tmp.right)
        return x

# @lc code=end

