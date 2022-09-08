#
# @lc app=leetcode.cn id=438 lang=python3
#
# [438] 找到字符串中所有字母异位词
#
# https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
#
# algorithms
# Medium (54.76%)
# Likes:    991
# Dislikes: 0
# Total Accepted:    225.3K
# Total Submissions: 411.4K
# Testcase Example:  '"cbaebabacd"\n"abc"'
#
# 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
# 
# 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
# 
# 
# 
# 示例 1:
# 
# 
# 输入: s = "cbaebabacd", p = "abc"
# 输出: [0,6]
# 解释:
# 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
# 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
# 
# 
# 示例 2:
# 
# 
# 输入: s = "abab", p = "ab"
# 输出: [0,1,2]
# 解释:
# 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
# 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
# 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
# 
# 
# 
# 
# 提示:
# 
# 
# 1 <= s.length, p.length <= 3 * 10^4
# s 和 p 仅包含小写字母
# 
# 
#

# @lc code=start
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        need = {}
        for x in p:
            need[x] = need.get(x, 0) + 1
        w = {}
        l, r, valid = 0, 0, 0
        res = []
        while r < len(s):
            x = s[r]
            r += 1
            if x in need:
                w[x] = w.get(x, 0) + 1
                if w[x] == need[x]:
                    valid += 1
            if r - l == len(p):
                if valid == len(need):
                    res.append(l)
                x = s[l]
                l += 1
                if x in need:
                    if w[x] == need[x]:
                        valid -= 1
                    w[x] -= 1
        return res

# @lc code=end

