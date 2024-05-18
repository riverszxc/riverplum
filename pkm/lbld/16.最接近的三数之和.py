#
# @lc app=leetcode.cn id=16 lang=python3
#
# [16] 最接近的三数之和
#
# https://leetcode.cn/problems/3sum-closest/description/
#
# algorithms
# Medium (44.77%)
# Likes:    1622
# Dislikes: 0
# Total Accepted:    561.2K
# Total Submissions: 1.3M
# Testcase Example:  '[-1,2,1,-4]\n1'
#
# 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
# 
# 返回这三个数的和。
# 
# 假定每组输入只存在恰好一个解。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [-1,2,1,-4], target = 1
# 输出：2
# 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [0,0,0], target = 1
# 输出：0
# 
# 
# 
# 
# 提示：
# 
# 
# 3 <= nums.length <= 1000
# -1000 <= nums[i] <= 1000
# -10^4 <= target <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        def twoSumClosest(start, subtarget):
            l = start
            r = len(nums) - 1
            subres = inf
            while l < r:
                t = nums[l] + nums[r]
                if abs(t - subtarget) < abs(subres - subtarget):
                    subres = t
                if t == subtarget:
                    return subres
                elif t < subtarget:
                    l += 1
                else:
                    r -= 1
            return subres
        nums.sort()
        res = inf
        for i in range(len(nums)-2):
            subsum = twoSumClosest(i+1, target-nums[i])
            if abs(subsum+nums[i]-target) < abs(res-target):
                res = subsum+nums[i]
        return res
# @lc code=end

