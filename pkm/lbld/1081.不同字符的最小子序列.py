#
# @lc app=leetcode.cn id=1081 lang=python3
#
# [1081] 不同字符的最小子序列
#
# https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/description/
#
# algorithms
# Medium (58.12%)
# Likes:    162
# Dislikes: 0
# Total Accepted:    22.3K
# Total Submissions: 38.3K
# Testcase Example:  '"bcabc"'
#
# 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
# 
# 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "bcabc"
# 输出："abc"
# 
# 
# 示例 2：
# 
# 
# 输入：s = "cbacdcbc"
# 输出："acdb"
# 
# 
# 
# 提示：
# 
# 
# 1 
# s 由小写英文字母组成
# 
# 
#

# @lc code=start
class Solution:
    def smallestSubsequence(self, s: str) -> str:
        exist = set()
        q = []
        cnt = {}
        for x in s:
            cnt[x] = cnt.get(x, 0) + 1
        for x in s:
            cnt[x] -= 1
            if x in exist:
                continue
            while q and q[-1] > x and cnt[q[-1]] > 0:
                exist.remove(q[-1])
                q.pop()
            q.append(x)
            exist.add(x)
        return ''.join(q)
# @lc code=end

