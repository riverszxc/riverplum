#
# @lc app=leetcode.cn id=90 lang=python3
#
# [90] 子集 II
#
# https://leetcode.cn/problems/subsets-ii/description/
#
# algorithms
# Medium (63.65%)
# Likes:    917
# Dislikes: 0
# Total Accepted:    238.1K
# Total Submissions: 374K
# Testcase Example:  '[1,2,2]'
#
# 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
# 
# 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,2]
# 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [0]
# 输出：[[],[0]]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# -10 
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        res = []
        def backtrack(start):
            result.append(res[:])
            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i-1]:
                    continue
                res.append(nums[i])
                backtrack(i + 1)
                res.pop()
        backtrack(0)
        return result
# @lc code=end

