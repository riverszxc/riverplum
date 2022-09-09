#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#
# https://leetcode.cn/problems/valid-parentheses/description/
#
# algorithms
# Easy (44.63%)
# Likes:    3484
# Dislikes: 0
# Total Accepted:    1.2M
# Total Submissions: 2.8M
# Testcase Example:  '"()"'
#
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
# 
# 有效字符串需满足：
# 
# 
# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
# 每个右括号都有一个对应的相同类型的左括号。
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：s = "()"
# 输出：true
# 
# 
# 示例 2：
# 
# 
# 输入：s = "()[]{}"
# 输出：true
# 
# 
# 示例 3：
# 
# 
# 输入：s = "(]"
# 输出：false
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= s.length <= 10^4
# s 仅由括号 '()[]{}' 组成
# 
# 
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        m = {')':'(', ']':'[', '}':'{'}
        q = []
        for x in s:
            if x not in m:
                q.append(x)
            else:
                if not q:
                    return False
                elif q[-1] == m[x]:
                    q.pop()
                else:
                    return False
        if q:
            return False
        return True
# @lc code=end

