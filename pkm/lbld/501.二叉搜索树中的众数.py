#
# @lc app=leetcode.cn id=501 lang=python3
#
# [501] 二叉搜索树中的众数
#
# https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
#
# algorithms
# Easy (53.86%)
# Likes:    506
# Dislikes: 0
# Total Accepted:    117.9K
# Total Submissions: 218.8K
# Testcase Example:  '[1,null,2,2]'
#
# 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
# 
# 如果树中有不止一个众数，可以按 任意顺序 返回。
# 
# 假定 BST 满足如下定义：
# 
# 
# 结点左子树中所含节点的值 小于等于 当前节点的值
# 结点右子树中所含节点的值 大于等于 当前节点的值
# 左子树和右子树都是二叉搜索树
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root = [1,null,2,2]
# 输出：[2]
# 
# 
# 示例 2：
# 
# 
# 输入：root = [0]
# 输出：[0]
# 
# 
# 
# 
# 提示：
# 
# 
# 树中节点的数目在范围 [1, 10^4] 内
# -10^5 <= Node.val <= 10^5
# 
# 
# 
# 
# 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        cur_cnt = 0
        max_cnt = 0
        pre = None
        def traverse(root):
            if not root:
                return None
            nonlocal res
            nonlocal cur_cnt
            nonlocal max_cnt
            nonlocal pre
            traverse(root.left)#利用BST的中序遍历有序
            if not pre:
                cur_cnt = 1
                max_cnt = 1
                res.append(root.val)
            elif pre.val == root.val:
                cur_cnt += 1
                if cur_cnt == max_cnt:
                    res.append(root.val)
                elif cur_cnt > max_cnt:
                    max_cnt = cur_cnt
                    res.clear()
                    res.append(root.val)
            else:
                cur_cnt = 1
                if max_cnt == 1:
                    res.append(root.val)
            pre = root
            # traverse(root.left)
            # pre = root
            traverse(root.right)
        traverse(root)
        return res
#      1
#    0   1
#   0 0 1 1
#  0
# @lc code=end

