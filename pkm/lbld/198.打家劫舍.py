#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
#
# https://leetcode.cn/problems/house-robber/description/
#
# algorithms
# Medium (53.78%)
# Likes:    2278
# Dislikes: 0
# Total Accepted:    625.8K
# Total Submissions: 1.2M
# Testcase Example:  '[1,2,3,1]'
#
# 
# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
# 
# 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：[1,2,3,1]
# 输出：4
# 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
# 偷窃到的最高金额 = 1 + 3 = 4 。
# 
# 示例 2：
# 
# 
# 输入：[2,7,9,3,1]
# 输出：12
# 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
# 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 0 
# 
# 
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        # dp = [[0,0] for x in range(n+1)]
        d_0, d_1 = 0, 0
        for i in range(1, n+1):
            # dp[i][0] = max(dp[i-1][1], dp[i-1][0])
            # dp[i][1] = dp[i-1][0]+nums[i-1]
            t = d_0
            d_0 = max(d_0, d_1)
            d_1 = t + nums[i-1]
        # return max(dp[n][0], dp[n][1])
        return max(d_0, d_1)
# @lc code=end

