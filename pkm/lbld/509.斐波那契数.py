#
# @lc app=leetcode.cn id=509 lang=python3
#
# [509] 斐波那契数
#
# https://leetcode.cn/problems/fibonacci-number/description/
#
# algorithms
# Easy (66.62%)
# Likes:    524
# Dislikes: 0
# Total Accepted:    443.4K
# Total Submissions: 665.6K
# Testcase Example:  '2'
#
# 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
# 
# 
# F(0) = 0，F(1) = 1
# F(n) = F(n - 1) + F(n - 2)，其中 n > 1
# 
# 
# 给定 n ，请计算 F(n) 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：n = 2
# 输出：1
# 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
# 
# 
# 示例 2：
# 
# 
# 输入：n = 3
# 输出：2
# 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
# 
# 
# 示例 3：
# 
# 
# 输入：n = 4
# 输出：3
# 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
# 
# 
# 
# 
# 提示：
# 
# 
# 0 <= n <= 30
# 
# 
#

# @lc code=start
class Solution:
    # def __init__(self):
    #     self.mem = {0:0,1:1}
    # def fib(self, n: int) -> int:
    #     if n == 0:
    #         return 0
    #     if n == 1:
    #         return 1
    #     n_1 = self.mem[n-1] if n-1 in self.mem else self.fib(n-1)
    #     n_2 = self.mem[n-2] if n-2 in self.mem else self.fib(n-2)
    #     self.mem[n] = n_1 + n_2
    #     return n_1 + n_2

    # def fib(self, n):
    #     if n == 0 or n == 1:
    #         return n
    #     x = [0] * (n+1)
    #     x[1] = 1
    #     for i in range(2,n+1):
    #         x[i] = x[i-1] + x[i-2]
    #     return x[n]
    def fib(self, n):
        if n == 0 or n == 1:
            return n
        x_2 = 0
        x_1 = 1
        for i in range(2,n+1):
            x = x_1 + x_2
            x_2 = x_1
            x_1 = x
        return x
# @lc code=end

