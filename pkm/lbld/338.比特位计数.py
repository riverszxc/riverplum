#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#
# https://leetcode.cn/problems/counting-bits/description/
#
# algorithms
# Easy (78.71%)
# Likes:    1101
# Dislikes: 0
# Total Accepted:    253.4K
# Total Submissions: 321.9K
# Testcase Example:  '2'
#
# 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans
# 作为答案。
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：n = 2
# 输出：[0,1,1]
# 解释：
# 0 --> 0
# 1 --> 1
# 2 --> 10
# 
# 
# 示例 2：
# 
# 
# 输入：n = 5
# 输出：[0,1,1,2,1,2]
# 解释：
# 0 --> 0
# 1 --> 1
# 2 --> 10
# 3 --> 11
# 4 --> 100
# 5 --> 101
# 
# 
# 
# 
# 提示：
# 
# 
# 0 <= n <= 10^5
# 
# 
# 
# 
# 进阶：
# 
# 
# 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
# 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    # def countBits(self, n: int) -> List[int]:
    #     res = [0]
    #     if n == 0:
    #         return res
    #     def countones(n):
    #         one = 0
    #         while n:
    #             n &= n-1
    #             one += 1
    #         return one
    #     for i in range(1, n+1):
    #         res.append(countones(i))
    #     return res
    # def countBits(self, n: int) -> List[int]:
    #     res = [0]
    #     if n == 0:
    #         return res
    #     high = 1
    #     for i in range(1, n+1):
    #         if i & i-1 == 0:
    #             high = i
    #         res.append(res[i-high] + 1)
    #     return res
    # def countBits(self, n: int) -> List[int]:
    #     res = [0]
    #     if n == 0:
    #         return res
    #     for i in range(1, n+1):
    #         res.append(res[i>>1] + (i&1))
    #     return res
    def countBits(self, n: int) -> List[int]:
        res = [0]
        if n == 0:
            return res
        for i in range(1, n+1):
            res.append(res[i & (i-1)] + 1)
        return res


# 0 0
# 1 1
# 2 1
# 3 2
# 4 1
# 5 2
# 6 2
# 7 3
# 8 1
# 9 2
# 10 2
# 11 3
# @lc code=end

