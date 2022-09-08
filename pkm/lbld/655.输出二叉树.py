#
# @lc app=leetcode.cn id=655 lang=python3
#
# [655] 输出二叉树
#
# https://leetcode.cn/problems/print-binary-tree/description/
#
# algorithms
# Medium (69.44%)
# Likes:    201
# Dislikes: 0
# Total Accepted:    33.7K
# Total Submissions: 48.5K
# Testcase Example:  '[1,2]'
#
# 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局
# 。构造此格式化布局矩阵需要遵循以下规则：
# 
# 
# 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
# 矩阵的列数 n 应该等于 2^height+1 - 1 。
# 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
# 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2^height-r-1] ，右子节点放置在
# res[r+1][c+2^height-r-1] 。
# 继续这一过程，直到树中的所有节点都妥善放置。
# 任意空单元格都应该包含空字符串 "" 。
# 
# 
# 返回构造得到的矩阵 res 。
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：root = [1,2]
# 输出：
# [["","1",""],
# ["2","",""]]
# 
# 
# 示例 2：
# 
# 
# 输入：root = [1,2,3,null,4]
# 输出：
# [["","","","1","","",""],
# ["","2","","","","3",""],
# ["","","4","","","",""]]
# 
# 
# 
# 
# 提示：
# 
# 
# 树中节点数在范围 [1, 2^10] 内
# -99 <= Node.val <= 99
# 树的深度在范围 [1, 10] 内
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
    def printTree(self, root: Optional[TreeNode]) -> List[List[str]]:
        res = []
        if not root:
            return res
        def finddepth(root):
            if not root:
                return 0
            l = finddepth(root.left)
            r = finddepth(root.right)
            return max(l, r) + 1
        height = finddepth(root) - 1
        rows = height+1
        columns = 2**(height+1)-1
        res = [[""]*columns for x in range(rows)]
        # res[0][int((columns-1)/2)] = str(root.val)
        def traverse(root, r, c):
            if not root:
                return
            # cur_r = r + 1
            # cur_c = c - 2**(height-r-1)
            # res[cur_r][cur_c] = str(root.val)
            # traverse(root.left,cur_r,cur_c)
            # traverse(root.right,cur_r,cur_c)
            res[r][c] = str(root.val)
            traverse(root.left, r + 1, c - 2**(height-r-1))
            traverse(root.right, r + 1, c + 2**(height-r-1))
        traverse(root, 0, int((columns-1)/2))
        return res
# @lc code=end

