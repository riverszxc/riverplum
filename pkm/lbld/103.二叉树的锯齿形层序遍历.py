#
# @lc app=leetcode.cn id=103 lang=python3
#
# [103] 二叉树的锯齿形层序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = [root]
        flag = True
        while q:
            level = []
            l = len(q)
            for _ in range(l):
                x = q.pop(0)
                if flag:
                    level.append(x.val)
                else:
                    level.insert(0, x.val)
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            flag = not flag
            res.append(level)
        return res
# @lc code=end

