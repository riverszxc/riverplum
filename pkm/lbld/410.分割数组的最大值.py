#
# @lc app=leetcode.cn id=410 lang=python3
#
# [410] 分割数组的最大值
#
# https://leetcode.cn/problems/split-array-largest-sum/description/
#
# algorithms
# Hard (58.85%)
# Likes:    729
# Dislikes: 0
# Total Accepted:    57K
# Total Submissions: 96.8K
# Testcase Example:  '[7,2,5,10,8]\n2'
#
# 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
# 
# 设计一个算法使得这 m 个子数组各自和的最大值最小。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [7,2,5,10,8], m = 2
# 输出：18
# 解释：
# 一共有四种方法将 nums 分割为 2 个子数组。 
# 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
# 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
# 
# 示例 2：
# 
# 
# 输入：nums = [1,2,3,4,5], m = 2
# 输出：9
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [1,4,4], m = 3
# 输出：4
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 1000
# 0 <= nums[i] <= 10^6
# 1 <= m <= min(50, nums.length)
# 
# 
#

# @lc code=start
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        l = max(nums)
        r = sum(nums)
        def isok(cap):
            i = 0
            for t in range(m):
                tmp = 0
                while tmp + nums[i] <= cap:
                    tmp += nums[i]
                    i += 1
                    if i == len(nums):
                        return True
            return False
        while l <= r:
            mid = int(l + (r-l)/2)
            if isok(mid):
                r = mid - 1
            else:
                l = mid + 1
        return l
# @lc code=end

