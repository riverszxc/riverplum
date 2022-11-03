#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子数组和
#
# https://leetcode.cn/problems/maximum-subarray/description/
#
# algorithms
# Medium (54.83%)
# Likes:    5299
# Dislikes: 0
# Total Accepted:    1.2M
# Total Submissions: 2.2M
# Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
#
# 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
# 
# 子数组 是数组中的一个连续部分。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
# 输出：6
# 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1]
# 输出：1
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [5,4,-1,7,8]
# 输出：23
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 
# 
# 
# 
# 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
# 
#

# @lc code=start
class Solution:
    # def maxSubArray(self, nums: List[int]) -> int:
    #     res = nums[0]
    #     def dp(i):
    #         if i == 0:
    #             return nums[i]
    #         nonlocal res
    #         t = max(nums[i], dp(i-1) + nums[i])
    #         res = max(res, t)
    #         return t
    #     dp(len(nums)-1)
    #     return res
    # def maxSubArray(self, nums):
    #     n = len(nums)
    #     dp = [0] * (n+1)
    #     dp[0] = float('-inf')
    #     for i in range(1, n + 1):
    #         dp[i] = max(nums[i-1], nums[i-1] + dp[i-1])
    #     return max(dp)
    # def maxSubArray(self, nums):
    #     n = len(nums)
    #     x_1 = float('-inf')
    #     x = nums[0]
    #     res = float('-inf')
    #     for i in range(1, n+1):
    #         x = max(nums[i-1], x_1 + nums[i-1])
    #         x_1 = x
    #         res = max(res, x)
    #     return res
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        # dp = [float('-inf')] * (n+1)
        # for i in range(1, n+1):
        #     dp[i] = max(nums[i-1], dp[i-1] + nums[i-1])
        # return max(dp)
        dp = res = float('-inf')
        for i in range(1, n+1):
            dp = max(nums[i-1], dp + nums[i-1])
            res = max(res, dp)
        return res

# @lc code=end

