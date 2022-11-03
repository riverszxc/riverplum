#
# @lc app=leetcode.cn id=322 lang=python3
#
# [322] 零钱兑换
#
# https://leetcode.cn/problems/coin-change/description/
#
# algorithms
# Medium (45.98%)
# Likes:    2117
# Dislikes: 0
# Total Accepted:    514.1K
# Total Submissions: 1.1M
# Testcase Example:  '[1,2,5]\n11'
#
# 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
# 
# 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
# 
# 你可以认为每种硬币的数量是无限的。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：coins = [1, 2, 5], amount = 11
# 输出：3 
# 解释：11 = 5 + 5 + 1
# 
# 示例 2：
# 
# 
# 输入：coins = [2], amount = 3
# 输出：-1
# 
# 示例 3：
# 
# 
# 输入：coins = [1], amount = 0
# 输出：0
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= coins.length <= 12
# 1 <= coins[i] <= 2^31 - 1
# 0 <= amount <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     mem = [amount] * (amount + 1)
    #     def dp(coins, amount):
    #         if amount == 0:
    #             return 0
    #         if amount < 0:
    #             return -1
    #         if mem[amount] < amount:
    #             return mem[amount]
    #         res = inf
    #         for x in coins:
    #             t = dp(coins, amount-x)
    #             if t == -1:
    #                 continue
    #             res = min(res, t+1)
    #         mem[amount] = res if res != inf else -1
    #         return mem[amount]
    #     return dp(coins, amount)
    def coinChange(self, coins: List[int], amount: int):
        # dp = [[amount+1] * (len(coins)+1) for _ in range(amount+1)]
        # for j in range(len(coins)+1):
        #     dp[0][j] = 0
        # for i in range(1, amount+1):
        #     for j in range(1, len(coins)+1):
        #         if coins[j-1] > i:
        #             dp[i][j] = dp[i][j-1]
        #         else:
        #             dp[i][j] = min(dp[i][j-1], dp[i-coins[j-1]][j] + 1)
        # return dp[amount][len(coins)] if dp[amount][len(coins)] < amount+1 else -1
        dp = [amount+1] * (amount+1)
        dp[0] = 0
        for i in range(1, amount+1):
            for j in range(1, len(coins)+1):
                if coins[j-1] <= i:
                    dp[i] = min(dp[i], dp[i-coins[j-1]]+1)
        return dp[amount] if dp[amount] < amount+1 else -1
# @lc code=end

