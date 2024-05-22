#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#
# https://leetcode.cn/problems/minimum-path-sum/description/
#
# algorithms
# Medium (69.33%)
# Likes:    1350
# Dislikes: 0
# Total Accepted:    417.5K
# Total Submissions: 602.2K
# Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
#
# 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
# 
# 说明：每次只能向下或者向右移动一步。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
# 输出：7
# 解释：因为路径 1→3→1→1→1 的总和最小。
# 
# 
# 示例 2：
# 
# 
# 输入：grid = [[1,2,3],[4,5,6]]
# 输出：12
# 
# 
# 
# 
# 提示：
# 
# 
# m == grid.length
# n == grid[i].length
# 1 
# 0 
# 
# 
#

# @lc code=start
class Solution:
    # def minPathSum(self, grid: List[List[int]]) -> int:
    #     m = len(grid)
    #     n = len(grid[0])
    #     mem = [[-1] * n for _ in range(m)]
    #     def dp(i, j):
    #         if i == 0 and j == 0:
    #             return grid[0][0]
    #         if mem[i][j] != -1:
    #             return mem[i][j]
    #         if i == 0:
    #             mem[i][j] = dp(i, j-1) + grid[i][j]
    #         elif j == 0:
    #             mem[i][j] = dp(i-1, j) + grid[i][j]
    #         else:
    #             mem[i][j] = min(dp(i, j-1), dp(i-1, j)) + grid[i][j]
    #         return mem[i][j]
    #     return dp(m-1, n-1)
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        dp = [[0]*(n+1) for i in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if i == 1:
                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1]
                elif j == 1:
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1]
        return dp[m][n]
# @lc code=end

