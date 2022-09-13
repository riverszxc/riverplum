#
# @lc app=leetcode.cn id=72 lang=python3
#
# [72] 编辑距离
#
# https://leetcode.cn/problems/edit-distance/description/
#
# algorithms
# Hard (62.69%)
# Likes:    2591
# Dislikes: 0
# Total Accepted:    303.3K
# Total Submissions: 483.6K
# Testcase Example:  '"horse"\n"ros"'
#
# 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
# 
# 你可以对一个单词进行如下三种操作：
# 
# 
# 插入一个字符
# 删除一个字符
# 替换一个字符
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：word1 = "horse", word2 = "ros"
# 输出：3
# 解释：
# horse -> rorse (将 'h' 替换为 'r')
# rorse -> rose (删除 'r')
# rose -> ros (删除 'e')
# 
# 
# 示例 2：
# 
# 
# 输入：word1 = "intention", word2 = "execution"
# 输出：5
# 解释：
# intention -> inention (删除 't')
# inention -> enention (将 'i' 替换为 'e')
# enention -> exention (将 'n' 替换为 'x')
# exention -> exection (将 'n' 替换为 'c')
# exection -> execution (插入 'u')
# 
# 
# 
# 
# 提示：
# 
# 
# 0 <= word1.length, word2.length <= 500
# word1 和 word2 由小写英文字母组成
# 
# 
#

# @lc code=start
class Solution:
    # def minDistance(self, word1: str, word2: str) -> int:
    #     mem = [[-1] * len(word2) for _ in range(len(word1))]
    #     def dp(i, j):
    #         if i < 0:
    #             return j + 1
    #         if j < 0:
    #             return i + 1
    #         if mem[i][j] != -1:
    #             return mem[i][j]
    #         if word1[i] == word2[j]:
    #             mem[i][j] = dp(i-1, j-1)
    #         else:
    #             mem[i][j] = 1 + min(dp(i, j-1), min(dp(i-1, j), dp(i-1, j-1)))
    #         return mem[i][j]
    #     return dp(len(word1)-1, len(word2)-1)
    def minDistance(self, word1, word2):
        m = len(word1)
        n = len(word2)
        dp = [[0] * (n+1) for _ in range(m+1)]
        for i in range(m+1):
            dp[i][0] = i
        for i in range(n+1):
            dp[0][i] = i
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = 1 + min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1]))
        return dp[m][n]
# @lc code=end

