#
# @lc app=leetcode.cn id=416 lang=python3
#
# [416] 分割等和子集
#
# https://leetcode.cn/problems/partition-equal-subset-sum/description/
#
# algorithms
# Medium (52.12%)
# Likes:    1492
# Dislikes: 0
# Total Accepted:    328.5K
# Total Submissions: 630.3K
# Testcase Example:  '[1,5,11,5]'
#
# 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,5,11,5]
# 输出：true
# 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
# 
# 示例 2：
# 
# 
# 输入：nums = [1,2,3,5]
# 输出：false
# 解释：数组不能分割成两个元素和相等的子集。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 1 
# 
# 
#

# @lc code=start
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        s = sum(nums)
        if s % 2 != 0:
            return False
        s = s // 2
        # mem = {}
        # def dp(i, remain):
        #     # print(i, remain, mem)
        #     if i < 0:
        #         return False
        #     if remain == 0:
        #         return True
        #     k = str(i)+'_'+str(remain)
        #     if k in mem:
        #         return mem[k]
        #     if remain < nums[i]:
        #         mem[k] = dp(i-1, remain)
        #     else:
        #         mem[k] = dp(i-1, remain) or dp(i-1, remain-nums[i])
        #     return mem[k]
        # return dp(n-1, s)
        dp = [[False] * (s+1) for _ in range(len(nums)+1)]
        for i in range(len(dp)):
            dp[i][0] = True
        for i in range(1, len(nums)+1):
            for j in range(1, s+1):
                if j < nums[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]
        return dp[n][s]
# @lc code=end

