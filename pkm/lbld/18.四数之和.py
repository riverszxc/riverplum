#
# @lc app=leetcode.cn id=18 lang=python3
#
# [18] 四数之和
#
# https://leetcode.cn/problems/4sum/description/
#
# algorithms
# Medium (38.26%)
# Likes:    1363
# Dislikes: 0
# Total Accepted:    365.5K
# Total Submissions: 955.4K
# Testcase Example:  '[1,0,-1,0,-2,2]\n0'
#
# 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
# nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
# 
# 
# 0 <= a, b, c, d < n
# a、b、c 和 d 互不相同
# nums[a] + nums[b] + nums[c] + nums[d] == target
# 
# 
# 你可以按 任意顺序 返回答案 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,0,-1,0,-2,2], target = 0
# 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [2,2,2,2,2], target = 8
# 输出：[[2,2,2,2]]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 200
# -10^9 <= nums[i] <= 10^9
# -10^9 <= target <= 10^9
# 
# 
#

# @lc code=start
class Solution:
    def threeSum(self, nums, start, target):
        def twosum(nums, start, target):
            res = []
            l = start
            r = len(nums) - 1
            while l < r:
                left = nums[l]
                right = nums[r]
                tsum = left + right
                if tsum == target:
                    res.append([nums[l], nums[r]])
                    while l < r and nums[l] == left:
                        l += 1
                    while l < r and nums[r] == right:
                        r -= 1
                elif tsum > target:
                    while l < r and nums[r] == right:
                        r -= 1
                else:
                    while l < r and nums[l] == left:
                        l += 1
            return res
        n = len(nums)
        res = []
        i = start
        while i < n:
            t = nums[i]
            r = twosum(nums, i+1, target-t)
            for x in r:
                res.append([t] + x)
            while i < n and nums[i] == t:
                i += 1
        return res
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        if not nums:
            return res
        nums.sort()
        n = len(nums)
        i = 0
        while i < n:
            r = self.threeSum(nums, i+1, target-nums[i])
            for x in r:
                res.append([nums[i]] + x)
            t = nums[i]
            while i < n and nums[i] == t:
                i += 1
        return res

# @lc code=end

