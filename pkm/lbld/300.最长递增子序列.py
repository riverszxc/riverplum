#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长递增子序列
#
# https://leetcode.cn/problems/longest-increasing-subsequence/description/
#
# algorithms
# Medium (54.07%)
# Likes:    2782
# Dislikes: 0
# Total Accepted:    612.1K
# Total Submissions: 1.1M
# Testcase Example:  '[10,9,2,5,3,7,101,18]'
#
# 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
# 
# 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]
# 的子序列。
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [10,9,2,5,3,7,101,18]
# 输出：4
# 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [0,1,0,3,2,3]
# 输出：4
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [7,7,7,7,7,7,7]
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 2500
# -10^4 <= nums[i] <= 10^4
# 
# 
# 
# 
# 进阶：
# 
# 
# 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
# 
# 
#

# @lc code=start
class Solution:
    # def lengthOfLIS(self, nums: List[int]) -> int:
    #     n = len(nums)
    #     dp = [1] * (n+1)
    #     for i in range(1, n+1):
    #         for j in range(1,i):
    #             if nums[i-1] > nums[j-1]:
    #                 dp[i] = max(dp[i], dp[j]+1)
    #     return max(dp)
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        group = []
        for i in range(n):
            if not group or nums[i] > group[-1]:
                group.append(nums[i])
            else:
                l, r = 0, len(group)-1
                while l <= r:
                    mid = l + (r-l)//2
                    if group[mid] >= nums[i]:
                        r = mid-1
                    else:
                        l = mid+1
                group[l] = nums[i]
        return len(group)
                

# @lc code=end

