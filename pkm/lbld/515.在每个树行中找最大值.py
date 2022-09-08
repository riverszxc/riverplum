#
# @lc app=leetcode.cn id=515 lang=python3
#
# [515] 在每个树行中找最大值
#
# https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
#
# algorithms
# Medium (66.38%)
# Likes:    274
# Dislikes: 0
# Total Accepted:    98.1K
# Total Submissions: 147.8K
# Testcase Example:  '[1,3,2,5,3,null,9]'
#
# 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
# 
# 
# 
# 示例1：
# 
# 
# 
# 
# 输入: root = [1,3,2,5,3,null,9]
# 输出: [1,3,9]
# 
# 
# 示例2：
# 
# 
# 输入: root = [1,2,3]
# 输出: [1,3]
# 
# 
# 
# 
# 提示：
# 
# 
# 二叉树的节点个数的范围是 [0,10^4]
# -2^31 <= Node.val <= 2^31 - 1
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
    # def largestValues(self, root: Optional[TreeNode]) -> List[int]:
    #     res = []
    #     if not root:
    #         return res
    #     q = [root]
    #     while q:
    #         res.append(max([x.val for x in q]))
    #         l = len(q)
    #         for i in range(l):
    #             tmp = q.pop(0)
    #             if tmp.left:
    #                 q.append(tmp.left)
    #             if tmp.right:
    #                 q.append(tmp.right)
    #     return res

    # def largestValues(self, root):
    #     res = []
    #     if not root:
    #         return res
    #     depth = 0
    #     def traverse(root):
    #         if not root:
    #             return
    #         nonlocal depth
    #         depth += 1
    #         if len(res) < depth:
    #             res.append(root.val)
    #         else:
    #             res[depth-1] = max(root.val, res[depth-1])
    #         traverse(root.left)
    #         traverse(root.right)
    #         depth -= 1
    #     traverse(root)
    #     return res
    
    def largestValues(self, root):
        res = []
        if not root:
            return res
        def traverse(root, depth):
            if not root:
                return
            if len(res) < depth+1:
                res.append(root.val)
            else:
                res[depth] = max(root.val, res[depth])
            traverse(root.left, depth + 1)
            traverse(root.right, depth + 1)
        traverse(root, 0)
        return res

# @lc code=end

