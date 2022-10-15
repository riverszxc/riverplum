#
# @lc app=leetcode.cn id=128 lang=python3
#
# [128] 最长连续序列
#
# https://leetcode.cn/problems/longest-consecutive-sequence/description/
#
# algorithms
# Medium (55.14%)
# Likes:    1439
# Dislikes: 0
# Total Accepted:    327.6K
# Total Submissions: 594K
# Testcase Example:  '[100,4,200,1,3,2]'
#
# 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
# 
# 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [100,4,200,1,3,2]
# 输出：4
# 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
# 
# 示例 2：
# 
# 
# 输入：nums = [0,3,7,2,5,8,4,6,0,1]
# 输出：9
# 
# 
# 
# 
# 提示：
# 
# 
# 0 
# -10^9 
# 
# 
#

# @lc code=start
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numset = set(nums)
        res = 0
        for x in numset:
            if x - 1 in numset:
                continue
            i = 1
            while x + i in numset:
                i += 1
            res = max(res, i)
        return res
            
# @lc code=end

