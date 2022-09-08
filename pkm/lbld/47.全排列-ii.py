#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#
# https://leetcode.cn/problems/permutations-ii/description/
#
# algorithms
# Medium (65.15%)
# Likes:    1179
# Dislikes: 0
# Total Accepted:    371.3K
# Total Submissions: 569.9K
# Testcase Example:  '[1,1,2]'
#
# 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,1,2]
# 输出：
# [[1,1,2],
# ⁠[1,2,1],
# ⁠[2,1,1]]
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 8
# -10 <= nums[i] <= 10
# 
# 
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        res = []
        used = [False] * len(nums)
        nums.sort()
        def backtrack():
            if len(res) == len(nums):
                result.append(res[:])
                return
            for i, n in enumerate(nums):
                if used[i]:
                    continue
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                    continue
                res.append(n)
                used[i] = True
                backtrack()
                used[i] = False
                res.pop()
        backtrack()
        return result

# @lc code=end

