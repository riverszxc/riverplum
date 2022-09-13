#
# @lc app=leetcode.cn id=354 lang=python3
#
# [354] 俄罗斯套娃信封问题
#
# https://leetcode.cn/problems/russian-doll-envelopes/description/
#
# algorithms
# Hard (40.30%)
# Likes:    803
# Dislikes: 0
# Total Accepted:    92K
# Total Submissions: 229K
# Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
#
# 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
# 
# 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
# 
# 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
# 
# 注意：不允许旋转信封。
# 
# 
# 示例 1：
# 
# 
# 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
# 输出：3
# 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
# 
# 示例 2：
# 
# 
# 输入：envelopes = [[1,1],[1,1],[1,1]]
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= envelopes.length <= 10^5
# envelopes[i].length == 2
# 1 <= wi, hi <= 10^5
# 
# 
#

# @lc code=start
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes.sort(key = lambda x : x[1], reverse = True)
        envelopes.sort(key = lambda x : x[0])
        # dp = [0] * n
        # res = 0
        # for i in range(n):
        #     t = 0
        #     for j in range(i):
        #         if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
        #             t = max(t, dp[j])
        #     dp[i] = t + 1
        #     res = max(res, dp[i])
        # return res
        groups = []
        for i in range(n):
            x = envelopes[i][1]
            l = 0
            r = len(groups) - 1
            while l <= r:
                mid = int(l + (r-l)/2)
                mx= groups[mid]
                if x <= mx:
                    r = mid - 1
                else:
                    l = mid + 1
            if l == len(groups):
                groups.append(x)
            else:
                groups[l] = x
        return len(groups)

# @lc code=end

