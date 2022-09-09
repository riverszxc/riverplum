#
# @lc app=leetcode.cn id=931 lang=python3
#
# [931] 下降路径最小和
#
# https://leetcode.cn/problems/minimum-falling-path-sum/description/
#
# algorithms
# Medium (67.19%)
# Likes:    190
# Dislikes: 0
# Total Accepted:    45.9K
# Total Submissions: 68.4K
# Testcase Example:  '[[2,1,3],[6,5,4],[7,8,9]]'
#
# 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
# 
# 下降路径
# 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置
# (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
# 。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
# 输出：13
# 解释：如图所示，为和最小的两条下降路径
# 
# 
# 示例 2：
# 
# 
# 
# 
# 输入：matrix = [[-19,57],[-40,-5]]
# 输出：-59
# 解释：如图所示，为和最小的下降路径
# 
# 
# 
# 
# 提示：
# 
# 
# n == matrix.length == matrix[i].length
# 1 <= n <= 100
# -100 <= matrix[i][j] <= 100
# 
# 
#

# @lc code=start
class Solution:
    # def minFallingPathSum(self, matrix: List[List[int]]) -> int:
    #     n = len(matrix)
    #     dp = [[0] * (n+1) for _ in range(n+1)]
    #     dp
    #     '''
    #     dp[0][:] = 0
    #     dp[i][j] = matrix[i-1][j-1] + min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1])
    #     '''
    #     for i in range(1, n+1):
    #         for j in range(1, n+1):
    #             # print(i,j)
    #             dp[i][j] = matrix[i-1][j-1] + min(min(dp[i-1][j], (dp[i-1][j-1] if j>1 else dp[i-1][j])),\
    #                 (dp[i-1][j+1] if j<n else dp[i-1][j]))
    #             # print(dp)
    #     return min(dp[n][1:])
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        res = float('inf')
        mem = [[float('inf')] * n for _ in range(n)]
        def dp(i, j):
            if i < 0 or j < 0 or j > n-1:
                return float('inf')
            if i == 0:
                return matrix[0][j]
            if mem[i][j] != float('inf'):
                return mem[i][j]
            mem[i][j] = matrix[i][j] + min(min(dp(i-1, j-1), dp(i-1, j)), dp(i-1, j+1))
            return mem[i][j]
        for i in range(n):
            res = min(res, dp(n-1, i))
        return res
# @lc code=end

