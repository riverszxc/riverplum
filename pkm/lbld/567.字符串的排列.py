#
# @lc app=leetcode.cn id=567 lang=python3
#
# [567] 字符串的排列
#
# https://leetcode.cn/problems/permutation-in-string/description/
#
# algorithms
# Medium (44.17%)
# Likes:    754
# Dislikes: 0
# Total Accepted:    218.4K
# Total Submissions: 494.6K
# Testcase Example:  '"ab"\n"eidbaooo"'
#
# 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
# 
# 换句话说，s1 的排列之一是 s2 的 子串 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s1 = "ab" s2 = "eidbaooo"
# 输出：true
# 解释：s2 包含 s1 的排列之一 ("ba").
# 
# 
# 示例 2：
# 
# 
# 输入：s1= "ab" s2 = "eidboaoo"
# 输出：false
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= s1.length, s2.length <= 10^4
# s1 和 s2 仅包含小写字母
# 
# 
#

# @lc code=start
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        need = {}
        for x in s1:
            need[x] = need.get(x, 0) + 1
        valid = 0
        window = {}
        l = 0
        r = 0
        while r < len(s2):
            x = s2[r]
            r += 1
            if x in need:
                window[x] = window.get(x, 0) + 1
                if window[x] == need[x]:
                    valid += 1
            if r - l == len(s1):
                if valid == len(need):
                    return True
                if s2[l] in need:
                    window[s2[l]] -= 1
                    # if window[s2[l]] < need[s2[l]]: #如果本来就没到阈值，这里也减了，就错了
                    if window[s2[l]] == need[s2[l]] - 1:
                        valid -= 1
                l += 1
        return False
# @lc code=end

