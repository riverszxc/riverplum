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
    # def longestPalindrome(self, s: str) -> str:
    #     maxlen = 0
    #     res = str()
    #     def lenofp(s, i):
    #         nonlocal maxlen
    #         nonlocal res
    #         a = i - 1
    #         b = i + 1
    #         l1 = 1
    #         while a >= 0 and b < len(s) and s[a] == s[b]:
    #             l1 += 2
    #             a -= 1
    #             b += 1
    #         if l1 > maxlen:
    #             maxlen = l1
    #             t = int((l1-1)/2)
    #             res = s[i-t:i+t+1]
    #         a = i
    #         b = i + 1
    #         l2 = 0
    #         while a >= 0 and b < len(s) and s[a] == s[b]:
    #             l2 += 2
    #             a -= 1
    #             b += 1
    #         if l2 > maxlen:
    #             maxlen = l2
    #             t = int(l2/2)
    #             res = s[i-(t-1):i+t+1]
    #     for i in range(len(s)):
    #         l = lenofp(s, i)
    #     return res
    
    def longestPalindrome(self, s):
        def findp(s, l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            return s[l+1:r]
        res = str()
        maxlen = 0
        for i in range(len(s)):
            p1 = findp(s, i, i)
            if len(p1) > maxlen:
                maxlen = len(p1)
                res = p1
            p2 = str()
            if i < len(s) - 1:
                p2 = findp(s, i, i+1)
            if len(p2) > maxlen:
                maxlen = len(p2)
                res = p2
        return res
# @lc code=end

