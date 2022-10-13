#
# @lc app=leetcode.cn id=62 lang=python3
#
# [62] 不同路径
#
# https://leetcode.cn/problems/unique-paths/description/
#
# algorithms
# Medium (67.52%)
# Likes:    1574
# Dislikes: 0
# Total Accepted:    525K
# Total Submissions: 777.3K
# Testcase Example:  '3\n7'
#
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
# 
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
# 
# 问总共有多少条不同的路径？
# 
# 
# 
# 示例 1：
# 
# 
# 输入：m = 3, n = 7
# 输出：28
# 
# 示例 2：
# 
# 
# 输入：m = 3, n = 2
# 输出：3
# 解释：
# 从左上角开始，总共有 3 条路径可以到达右下角。
# 1. 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右
# 3. 向下 -> 向右 -> 向下
# 
# 
# 示例 3：
# 
# 
# 输入：m = 7, n = 3
# 输出：28
# 
# 
# 示例 4：
# 
# 
# 输入：m = 3, n = 3
# 输出：6
# 
# 
# 
# 提示：
# 
# 
# 1 
# 题目数据保证答案小于等于 2 * 10^9
# 
# 
#

# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # dp = [[0] * (n+1) for _ in range(m+1)]
        # for i in range(1, m+1):
        #     for j in range(1, n+1):
        #         if i == 1 and j == 1:
        #             dp[i][j] = 1
        #         else:
        #             dp[i][j] = dp[i-1][j] + dp[i][j-1]
        # return dp[m][n]
        pre = [0] * (n+1)
        cur = [0] * (n+1)
        for i in range(1, m+1):
            for j in range(1, n+1):
                if i == 1 and j == 1:
                    cur[j] = 1
                else:
                    cur[j] = cur[j-1] + pre[j]
                pre[j] = cur[j]
        return cur[n]


# @lc code=end

