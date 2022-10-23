#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#
# https://leetcode.cn/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (37.08%)
# Likes:    5648
# Dislikes: 0
# Total Accepted:    1.2M
# Total Submissions: 3.2M
# Testcase Example:  '"babad"'
#
# 给你一个字符串 s，找到 s 中最长的回文子串。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "babad"
# 输出："bab"
# 解释："aba" 同样是符合题意的答案。
# 
# 
# 示例 2：
# 
# 
# 输入：s = "cbbd"
# 输出："bb"
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= s.length <= 1000
# s 仅由数字和英文字母组成
# 
# 
#

# @lc code=start


class Solution:
    def longestPalindrome(self, s):
        maxlen, start= 0, 0
        def find(i, j):
            if j == len(s):
                return
            while i >= 0 and j < len(s) and s[i] == s[j]:
                i -= 1
                j += 1
            nonlocal maxlen, start
            if maxlen < (j-1) - (i+1) + 1:
                maxlen = (j-1) - (i+1) + 1
                start = i + 1
        for i in range(len(s)):
            find(i, i)
            find(i, i+1)
        return s[start:(start+maxlen)]
# @lc code=end

