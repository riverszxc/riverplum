#
# @lc app=leetcode.cn id=617 lang=python3
#
# [617] 合并二叉树
#
# https://leetcode.cn/problems/merge-two-binary-trees/description/
#
# algorithms
# Easy (79.08%)
# Likes:    1070
# Dislikes: 0
# Total Accepted:    324.4K
# Total Submissions: 410.2K
# Testcase Example:  '[1,3,2,5]\n[2,1,3,null,4,null,7]'
#
# 给你两棵二叉树： root1 和 root2 。
# 
# 
# 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为
# null 的节点将直接作为新二叉树的节点。
# 
# 返回合并后的二叉树。
# 
# 注意: 合并过程必须从两个树的根节点开始。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
# 输出：[3,4,5,5,4,null,7]
# 
# 
# 示例 2：
# 
# 
# 输入：root1 = [1], root2 = [1,2]
# 输出：[2,2]
# 
# 
# 
# 
# 提示：
# 
# 
# 两棵树中的节点数目在范围 [0, 2000] 内
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
    # def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
    #     def merge(root1, root2):
    #         if not root1 and not root2:
    #             return None, None
    #         if not root1:
    #             return None, root2
    #         if not root2:
    #             return root1, None
    #         l1, l2 = merge(root1.left, root2.left)
    #         r1, r2 = merge(root1.right, root2.right)
    #         if not l1 and l2:
    #             root1.left = l2
    #         elif l1 and l2:
    #             root1.left.val = l1.val + l2.val
    #         if not r1 and r2:
    #             root1.right = r2
    #         elif r1 and r2:
    #             root1.right.val = r1.val + r2.val
    #         return root1, root2
    #     l1, l2 = merge(root1, root2)
    #     if not l1 and l2:
    #         return l2
    #     elif l1 and l2:
    #         l1.val = l1.val + l2.val
    #     return l1
    
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]):
        if not root1:
            return root2
        if not root2:
            return root1
        root1.val += root2.val
        root1.left = self.mergeTrees(root1.left, root2.left)
        root1.right = self.mergeTrees(root1.right, root2.right)
        return root1
        
        
# @lc code=end

