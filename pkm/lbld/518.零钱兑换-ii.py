#
# @lc app=leetcode.cn id=518 lang=python3
#
# [518] 零钱兑换 II
#
# https://leetcode.cn/problems/coin-change-2/description/
#
# algorithms
# Medium (69.47%)
# Likes:    917
# Dislikes: 0
# Total Accepted:    195.2K
# Total Submissions: 280.9K
# Testcase Example:  '5\n[1,2,5]'
#
# 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
# 
# 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
# 
# 假设每一种面额的硬币有无限个。 
# 
# 题目数据保证结果符合 32 位带符号整数。
# 
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：amount = 5, coins = [1, 2, 5]
# 输出：4
# 解释：有四种方式可以凑成总金额：
# 5=5
# 5=2+2+1
# 5=2+1+1+1
# 5=1+1+1+1+1
# 
# 
# 示例 2：
# 
# 
# 输入：amount = 3, coins = [2]
# 输出：0
# 解释：只用面额 2 的硬币不能凑成总金额 3 。
# 
# 
# 示例 3：
# 
# 
# 输入：amount = 10, coins = [10] 
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 1 
# coins 中的所有值 互不相同
# 0 
# 
# 
#

# @lc code=start
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # n = len(coins)
        # mem = {}
        # def dp(i, remain):
        #     if remain == 0:
        #         return 1
        #     if i < 0:
        #         return 0
        #     k = str(i) + '_' + str(remain)
        #     if k in mem:
        #         return mem[k]
        #     if remain < coins[i]:
        #         mem[k] = dp(i-1, remain)
        #     else:
        #         mem[k] =  dp(i-1, remain) + dp(i, remain-coins[i])
        #     return mem[k]
        # return dp(n-1, amount)
        n = len(coins)
        dp = [[0] * (n+1) for _ in range(amount+1)]
        for j in range(n+1):
            dp[0][j] = 1
        for i in range(1, amount+1):
            for j in range(1, n+1):
                if coins[j-1] > i:
                    dp[i][j] = dp[i][j-1]
                else:
                    dp[i][j] = dp[i][j-1] + dp[i-coins[j-1]][j]
        return dp[amount][n]

# @lc code=end

