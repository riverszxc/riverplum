#
# @lc app=leetcode.cn id=316 lang=python3
#
# [316] 去除重复字母
#
# https://leetcode.cn/problems/remove-duplicate-letters/description/
#
# algorithms
# Medium (48.00%)
# Likes:    807
# Dislikes: 0
# Total Accepted:    99.7K
# Total Submissions: 207.7K
# Testcase Example:  '"bcabc"'
#
# 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
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
# 1 <= s.length <= 10^4
# s 由小写英文字母组成
# 
# 
# 
# 
# 注意：该题与 1081
# https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
# 相同
# 
#

# @lc code=start
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        exist = set()
        q = []
        cnt = {}
        for x in s:
            cnt[x] = cnt.get(x, 0) + 1
        for x in s:
            cnt[x] -= 1
            if x in exist:
                continue
            while q and x < q[-1] and cnt[q[-1]] > 0:
                exist.remove(q[-1])
                q.pop()
            q.append(x)
            exist.add(x)
        return ''.join(q)
# @lc code=end

