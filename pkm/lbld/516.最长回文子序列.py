#
# @lc app=leetcode.cn id=516 lang=python3
#
# [516] 最长回文子序列
#
# https://leetcode.cn/problems/longest-palindromic-subsequence/description/
#
# algorithms
# Medium (66.91%)
# Likes:    885
# Dislikes: 0
# Total Accepted:    146.8K
# Total Submissions: 219.4K
# Testcase Example:  '"bbbab"'
#
# 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
# 
# 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "bbbab"
# 输出：4
# 解释：一个可能的最长回文子序列为 "bbbb" 。
# 
# 
# 示例 2：
# 
# 
# 输入：s = "cbbd"
# 输出：2
# 解释：一个可能的最长回文子序列为 "bb" 。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# s 仅由小写英文字母组成
# 
# 
#

# @lc code=start
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        mem = [[1] * n for _ in range(n)]
        def dp(i, j):
            if i == j:
                return 1
            if i > j:
                return 0
            if mem[i][j] > 1:
                return mem[i][j]
            if s[i] == s[j]:
                mem[i][j] = dp(i+1, j-1) + 2
            else:
                mem[i][j] = max(dp(i+1, j), dp(i, j-1))
            return mem[i][j]
        return dp(0, n-1)
# @lc code=end

