#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#
# https://leetcode.cn/problems/permutations/description/
#
# algorithms
# Medium (78.74%)
# Likes:    2204
# Dislikes: 0
# Total Accepted:    711.3K
# Total Submissions: 903.4K
# Testcase Example:  '[1,2,3]'
#
# 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [0,1]
# 输出：[[0,1],[1,0]]
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [1]
# 输出：[[1]]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 6
# -10 <= nums[i] <= 10
# nums 中的所有整数 互不相同
# 
# 
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        res = []
        used = [False] * len(nums)
        def backtrack():
            if len(res) == len(nums):
                result.append(res[:])
                return
            for i, n in enumerate(nums):
                if used[i]:
                    continue
                used[i] = True
                res.append(n)
                backtrack()
                used[i] = False
                res.pop()
        backtrack()
        return result
# @lc code=end

