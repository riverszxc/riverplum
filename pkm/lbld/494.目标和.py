#
# @lc app=leetcode.cn id=494 lang=python3
#
# [494] 目标和
#
# https://leetcode.cn/problems/target-sum/description/
#
# algorithms
# Medium (49.08%)
# Likes:    1374
# Dislikes: 0
# Total Accepted:    277.1K
# Total Submissions: 564.6K
# Testcase Example:  '[1,1,1,1,1]\n3'
#
# 给你一个整数数组 nums 和一个整数 target 。
# 
# 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
# 
# 
# 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
# 
# 
# 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,1,1,1,1], target = 3
# 输出：5
# 解释：一共有 5 种方法让最终目标和为 3 。
# -1 + 1 + 1 + 1 + 1 = 3
# +1 - 1 + 1 + 1 + 1 = 3
# +1 + 1 - 1 + 1 + 1 = 3
# +1 + 1 + 1 - 1 + 1 = 3
# +1 + 1 + 1 + 1 - 1 = 3
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1], target = 1
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 0 
# 0 
# -1000 
# 
# 
#

# @lc code=start
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # n = len(nums)
        # path = []
        # mem = {}
        # def dp(i, remain):
        #     if i < 0:
        #         if remain == 0:
        #             return 1
        #         return 0
        #     k = str(i) + '_' + str(remain)
        #     if k in mem:
        #         return mem[k]
        #     mem[k] = dp(i-1, remain + nums[i]) + dp(i-1, remain - nums[i])
        #     return mem[k]
        # return dp(n-1, target)
        s = sum(nums) + target
        if s % 2 == 1 or s < 0:
            return 0
        s = s // 2
        # mem = {}
        # def dp(i, remain):
        #     print(i, remain, mem)
        #     if i < 0:
        #         return 0
        #     if remain == 0:
        #         return 1
        #     k = str(i) + '_' + str(remain)
        #     if k in mem:
        #         return mem[k]
        #     if nums[i] > remain:
        #         mem[k] = dp(i-1, remain)
        #     else:
        #         mem[k] = dp(i-1, remain) + dp(i-1, remain - nums[i])
        #     return mem[k]
            
        # return dp(len(nums)-1, s)
        dp = [[0] * (s+1) for _ in range(len(nums)+1)]
        # for i in range(len(dp)):
        #     dp[i][0] = 1
        dp[0][0] = 1
        for i in range(1, len(nums)+1):
            for j in range(0, s+1):
                if j < nums[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
        return dp[len(nums)][s]

# @lc code=end

