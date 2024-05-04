#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#
# https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
#
# algorithms
# Medium (71.59%)
# Likes:    2291
# Dislikes: 0
# Total Accepted:    643.4K
# Total Submissions: 898.7K
# Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
#
# 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
# 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
# 
# 
# 
# 示例 1:
# 
# 
# 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
# 输出: [3,9,20,null,null,15,7]
# 
# 
# 示例 2:
# 
# 
# 输入: preorder = [-1], inorder = [-1]
# 输出: [-1]
# 
# 
# 
# 
# 提示:
# 
# 
# 1 <= preorder.length <= 3000
# inorder.length == preorder.length
# -3000 <= preorder[i], inorder[i] <= 3000
# preorder 和 inorder 均 无重复 元素
# inorder 均出现在 preorder
# preorder 保证 为二叉树的前序遍历序列
# inorder 保证 为二叉树的中序遍历序列
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
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def build(preleft, preright, inleft, inright):
            if preleft > preright or inleft > inright:
                return None
            val = preorder[preleft]
            mid = m[val]
            leftlen = mid - inleft
            root = TreeNode(val)
            root.left = build(preleft+1, preleft+leftlen, inleft, mid-1)
            root.right = build(preleft+leftlen+1, preright, mid+1, inright)
            return root
        m = {}
        for i, x in enumerate(inorder):
            m[x] = i
        return build(0, len(preorder)-1, 0, len(inorder))
# @lc code=end

