#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#
# https://leetcode.cn/problems/subsets/description/
#
# algorithms
# Medium (80.76%)
# Likes:    1772
# Dislikes: 0
# Total Accepted:    514.6K
# Total Submissions: 637.2K
# Testcase Example:  '[1,2,3]'
#
# 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
# 
# 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,3]
# 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
# nums 中的所有元素 互不相同
# 
# 
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        res = []
        def backtrack(start):
            result.append(res[:])
            for i in range(start, len(nums)):
                res.append(nums[i])
                backtrack(i+1)
                res.pop()
        backtrack(0)
        return result
# @lc code=end

