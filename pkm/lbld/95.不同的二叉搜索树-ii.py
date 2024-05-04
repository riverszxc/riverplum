#
# @lc app=leetcode.cn id=95 lang=python3
#
# [95] 不同的二叉搜索树 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        def generate(i, j):
            if i > j:
                return [None]
            all = []
            for k in range(i, j+1):
                lefts = generate(i, k-1)
                rights = generate(k+1, j)
                for l in lefts:
                    for r in rights:
                        all.append(TreeNode(k, l, r))
            return all
        return generate(1, n)
# @lc code=end

