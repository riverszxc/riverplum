#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N 皇后
#
# https://leetcode.cn/problems/n-queens/description/
#
# algorithms
# Hard (74.10%)
# Likes:    1489
# Dislikes: 0
# Total Accepted:    248K
# Total Submissions: 334.7K
# Testcase Example:  '4'
#
# 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
# 
# n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
# 
# 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
# 
# 
# 
# 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：n = 4
# 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
# 解释：如上图所示，4 皇后问题存在两个不同的解法。
# 
# 
# 示例 2：
# 
# 
# 输入：n = 1
# 输出：[["Q"]]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= n <= 9
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        res = [['.'] * n for i in range(n)]
        def isvalid(row, col):
            for i in range(col):
                if res[row][i] == 'Q':
                    return False
            for i in range(row):
                if res[i][col] == 'Q':
                    return False
            x, y = row, col
            while x >= 0 and y >= 0:
                if res[x][y] == 'Q':
                    return False
                x -= 1
                y -= 1
            x, y = row, col
            while x >= 0 and y < n:
                if res[x][y] == 'Q':
                    return False
                x -= 1
                y += 1
            return True
        def backtrack(row):
            if row == n:
                result.append([''.join(x) for x in res])
                return
            for col in range(n):
                if not isvalid(row, col):
                    continue
                res[row][col] = 'Q'
                backtrack(row + 1)
                res[row][col] = '.'
        backtrack(0)
        return result

# @lc code=end

