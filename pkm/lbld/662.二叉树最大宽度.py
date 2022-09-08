#
# @lc app=leetcode.cn id=662 lang=python3
#
# [662] 二叉树最大宽度
#
# https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
#
# algorithms
# Medium (43.59%)
# Likes:    501
# Dislikes: 0
# Total Accepted:    75.7K
# Total Submissions: 173.7K
# Testcase Example:  '[1,3,2,5,3,null,9]'
#
# 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
# 
# 树的 最大宽度 是所有层中最大的 宽度 。
# 
# 
# 
# 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null
# 节点，这些 null 节点也计入长度。
# 
# 题目数据保证答案将会在  32 位 带符号整数范围内。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root = [1,3,2,5,3,null,9]
# 输出：4
# 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
# 
# 
# 示例 2：
# 
# 
# 输入：root = [1,3,2,5,null,null,9,6,null,7]
# 输出：7
# 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
# 
# 
# 示例 3：
# 
# 
# 输入：root = [1,3,2,5]
# 输出：2
# 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
# 
# 
# 
# 
# 提示：
# 
# 
# 树中节点的数目范围是 [1, 3000]
# -100 <= Node.val <= 100
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
    # def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
    #     maxwidth = 0
    #     if not root:
    #         return maxwidth
    #     q = [(root, 1)]
    #     while q:
    #         l = len(q)
    #         left, right = 0, 0
    #         for i in range(l):
    #             node, id = q.pop(0)
    #             if i == 0:
    #                 left = id
    #             if i == l -1:
    #                 right = id
    #             if node.left:
    #                 q.append((node.left, id*2))
    #             if node.right:
    #                 q.append((node.right, id*2+1))
    #         maxwidth = max(maxwidth, right - left + 1)
    #     return maxwidth
    
    def widthOfBinaryTree(self, root):
        if not root:
            return 0
        maxwidth = 1
        lefts = []
        def traverse(root, depth, id):
            if not root:
                return
            nonlocal maxwidth
            depth += 1
            if depth > len(lefts):
                lefts.append(id)
            maxwidth = max(maxwidth, id - lefts[depth-1] + 1)
            traverse(root.left, depth, id*2)
            traverse(root.right, depth, id*2+1)
            depth -= 1
        traverse(root, 0, 1)
        return maxwidth
            




# @lc code=end

