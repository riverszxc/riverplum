#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#
# https://leetcode.cn/problems/maximal-square/description/
#
# algorithms
# Medium (49.29%)
# Likes:    1294
# Dislikes: 0
# Total Accepted:    235.5K
# Total Submissions: 477.6K
# Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
#
# 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：matrix =
# [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
# 输出：4
# 
# 
# 示例 2：
# 
# 
# 输入：matrix = [["0","1"],["1","0"]]
# 输出：1
# 
# 
# 示例 3：
# 
# 
# 输入：matrix = [["0"]]
# 输出：0
# 
# 
# 
# 
# 提示：
# 
# 
# m == matrix.length
# n == matrix[i].length
# 1 
# matrix[i][j] 为 '0' 或 '1'
# 
# 
#

# @lc code=start
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        mem = [[0] * n for _ in range(m)]
        def dp(i, j):
            if i < 0 or j < 0:
                return 0
            if mem[i][j] != 0:
                return mem[i][j]
            t = min(dp(i, j-1), dp(i-1, j-1), dp(i-1, j))
            if matrix[i][j] == '0':
                mem[i][j] = 0
            else:
                mem[i][j] = t + 1
            nonlocal res
            res = max(res, mem[i][j])
            return mem[i][j]
        dp(m-1, n-1)
        return res**2
# @lc code=end

