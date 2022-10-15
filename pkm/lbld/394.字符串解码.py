#
# @lc app=leetcode.cn id=394 lang=python3
#
# [394] 字符串解码
#
# https://leetcode.cn/problems/decode-string/description/
#
# algorithms
# Medium (56.76%)
# Likes:    1328
# Dislikes: 0
# Total Accepted:    207.9K
# Total Submissions: 366.3K
# Testcase Example:  '"3[a]2[bc]"'
#
# 给定一个经过编码的字符串，返回它解码后的字符串。
# 
# 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
# 
# 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
# 
# 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "3[a]2[bc]"
# 输出："aaabcbc"
# 
# 
# 示例 2：
# 
# 
# 输入：s = "3[a2[c]]"
# 输出："accaccacc"
# 
# 
# 示例 3：
# 
# 
# 输入：s = "2[abc]3[cd]ef"
# 输出："abcabccdcdcdef"
# 
# 
# 示例 4：
# 
# 
# 输入：s = "abc3[cd]xyz"
# 输出："abccdcdcdxyz"
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= s.length <= 30
# s 由小写英文字母、数字和方括号 '[]' 组成
# s 保证是一个 有效 的输入。
# s 中所有整数的取值范围为 [1, 300] 
# 
# 
#

# @lc code=start
class Solution:
    # def decodeString(self, s: str) -> str:
    #     i = 0
    #     def dfs():
    #         nonlocal i
    #         res = []
    #         # for i in range(start, len(s)):
    #         while i < len(s):
    #             if s[i] >= '0' and s[i] <= '9':
    #                 multi = 0
    #                 while s[i] >= '0' and s[i] <= '9':
    #                     multi = 10 * multi + int(s[i])
    #                     i += 1
    #             elif s[i] == '[':
    #                 i += 1
    #                 t = dfs()
    #                 for _ in range(multi):
    #                     res.append(t)
    #             elif s[i] >= 'a' and s[i] <= 'z':
    #                 res.append(s[i])
    #                 i += 1
    #             else:
    #                 i += 1
    #                 return ''.join(res)
    #         return ''.join(res)
    #     return dfs()
    def decodeString(self, s: str) -> str:
        def dfs(i):
            res = ''
            multi = 0
            while i < len(s):
                if s[i] >= '0' and s[i] <= '9':
                    multi = 10 * multi + int(s[i])
                elif s[i] == '[':
                    t, i = dfs(i+1)
                    res += t * multi
                    multi = 0
                elif s[i] >= 'a' and s[i] <= 'z':
                    res += s[i]
                else:
                    return res, i
                i += 1
            return res
        return dfs(0)
# @lc code=end

