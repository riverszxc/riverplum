#
# @lc app=leetcode.cn id=912 lang=python3
#
# [912] 排序数组
#
# https://leetcode.cn/problems/sort-an-array/description/
#
# algorithms
# Medium (55.01%)
# Likes:    705
# Dislikes: 0
# Total Accepted:    460.8K
# Total Submissions: 838.4K
# Testcase Example:  '[5,2,3,1]'
#
# 给你一个整数数组 nums，请你将该数组升序排列。
# 
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [5,2,3,1]
# 输出：[1,2,3,5]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [5,1,1,2,0,0]
# 输出：[0,0,1,1,2,5]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 5 * 10^4
# -5 * 10^4 <= nums[i] <= 5 * 10^4
# 
# 
#

# @lc code=start
import random

class Solution:
    # def sortArray(self, nums: List[int]) -> List[int]:
    #     def partition(l, r):
    #         pivot = nums[l]
    #         i = l + 1
    #         j = r
    #         while i <= j:
    #             while i < r and nums[i] <= pivot:
    #                 i += 1
    #             while j > l and nums[j] > pivot:
    #                 j -= 1
    #             if i >= j:
    #                 break
    #             tmp = nums[i]
    #             nums[i] = nums[j]
    #             nums[j] = tmp
    #         nums[l] = nums[j]
    #         nums[j] = pivot
    #         return j
    #     def quick(l, r):
    #         if l >= r:
    #             return
    #         p = partition(l, r)
    #         quick(l, p-1)
    #         quick(p+1, r)
    #     def shuff():
    #         n = len(nums)
    #         for i in range(n):
    #             r = random.randint(i, n-1)
    #             tmp = nums[r]
    #             nums[r] = nums[i]
    #             nums[i] = tmp
    #     shuff()
    #     quick(0, len(nums)-1)
    #     return nums
    # def sortArray(self, nums: List[int]) -> List[int]:
    #     def quicksort(l, r):
    #         if l > r:
    #             return
    #         p = partition(l, r)
    #         quicksort(l, p-1)
    #         quicksort(p+1, r)
    #     def partition(l, r):
    #         t = random.randint(l, r)
    #         nums[t], nums[r] = nums[r], nums[t]
    #         i = l - 1
    #         for j in range(l, r):
    #             if nums[j] < nums[r]:
    #                 i += 1
    #                 nums[i], nums[j] = nums[j], nums[i]
    #         i += 1
    #         nums[i], nums[r] = nums[r], nums[i]
    #         return i
    #     quicksort(0, len(nums)-1)
    #     return nums
    def sortArray(self, nums: List[int]) -> List[int]:
        tmp = nums[:]
        def mergesort(l, r):
            if l >=r:
                return
            mid = l + (r - l) // 2
            mergesort(l, mid)
            mergesort(mid+1, r)
            i, j = l, mid+1
            x = l
            while i <= mid or j <= r:
                if i > mid or (j <= r and nums[j] < nums[i]):
                    tmp[x] = nums[j]
                    j += 1
                else:
                    tmp[x] = nums[i]
                    i += 1
                x += 1
            nums[l:(r+1)] = tmp[l:(r+1)]
        mergesort(0, len(nums)-1)
        return nums

# @lc code=end

