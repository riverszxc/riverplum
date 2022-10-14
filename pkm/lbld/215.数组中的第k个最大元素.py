#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#
# https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
#
# algorithms
# Medium (64.36%)
# Likes:    1922
# Dislikes: 0
# Total Accepted:    756.8K
# Total Submissions: 1.2M
# Testcase Example:  '[3,2,1,5,6,4]\n2'
#
# 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
# 
# 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
# 
# 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
# 
# 
# 
# 示例 1:
# 
# 
# 输入: [3,2,1,5,6,4], k = 2
# 输出: 5
# 
# 
# 示例 2:
# 
# 
# 输入: [3,2,3,1,2,4,5,5,6], k = 4
# 输出: 4
# 
# 
# 
# 提示： 
# 
# 
# 1 <= k <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        kk = n - k
        def partition(i, j):
            t = random.randint(i, j)
            pivot = nums[t]
            nums[i], nums[t] = nums[t], nums[i]
            l, r = i+1, j
            while l <= r:
                while r > i and nums[r] >= pivot:
                    r -= 1
                while l < j and nums[l] < pivot:
                    l += 1
                if l >= r:
                    break
                nums[l], nums[r] = nums[r], nums[l]
            nums[i], nums[r] = nums[r], nums[i]
            return r
            
        l, r = 0, n-1
        while l <= r:
            p = partition(l, r)
            if p == kk:
                return nums[p]
            elif p < kk:
                l = p + 1
            else:
                r = p - 1
        return -1

# @lc code=end

