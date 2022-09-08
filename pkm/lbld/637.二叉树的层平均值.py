#
# @lc app=leetcode.cn id=637 lang=python3
#
# [637] 二叉树的层平均值
#
# https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/
#
# algorithms
# Easy (69.65%)
# Likes:    367
# Dislikes: 0
# Total Accepted:    114.7K
# Total Submissions: 164.6K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入：root = [3,9,20,null,null,15,7]
# 输出：[3.00000,14.50000,11.00000]
# 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
# 因此返回 [3, 14.5, 11] 。
# 
# 
# 示例 2:
# 
# 
# 
# 
# 输入：root = [3,9,20,15,7]
# 输出：[3.00000,14.50000,11.00000]
# 
# 
# 
# 
# 提示：
# 
# 
# 
# 
# 树中节点数量在 [1, 10^4] 范围内
# -2^31 <= Node.val <= 2^31 - 1
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
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        res = []
        if not root:
            return res
        q = [root]
        while q:
            l = len(q)
            # res .append(sum([x.val for x in q])/l)
            tmp_avg = 0
            for i in range(l):
                t = q.pop(0)
                tmp_avg = tmp_avg * (i/(i+1)) + t.val/(i+1)
                if t.left:
                    q.append(t.left)
                if t.right:
                    q.append(t.right)
            res.append(tmp_avg)
        return res
                
# @lc code=end

