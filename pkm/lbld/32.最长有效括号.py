#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode.cn/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (36.96%)
# Likes:    2039
# Dislikes: 0
# Total Accepted:    323.1K
# Total Submissions: 874K
# Testcase Example:  '"(()"'
#
# 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "(()"
# 输出：2
# 解释：最长有效括号子串是 "()"
# 
# 
# 示例 2：
# 
# 
# 输入：s = ")()())"
# 输出：4
# 解释：最长有效括号子串是 "()()"
# 
# 
# 示例 3：
# 
# 
# 输入：s = ""
# 输出：0
# 
# 
# 
# 
# 提示：
# 
# 
# 0 
# s[i] 为 '(' 或 ')'
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n+1) #以i结尾的最长有效括号
        q = []
        for i, x in enumerate(s):
            if x == '(':
                dp[i+1] = 0
                q.append(i)
            else:
                if q:
                    left = q.pop()
                    dp[i+1] = dp[left] + i - left + 1
                else:
                    dp[i+1] = 0
        return max(dp)
# @lc code=end

