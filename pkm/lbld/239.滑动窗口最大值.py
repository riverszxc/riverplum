#
# @lc app=leetcode.cn id=239 lang=python3
#
# [239] 滑动窗口最大值
#
# https://leetcode.cn/problems/sliding-window-maximum/description/
#
# algorithms
# Hard (50.02%)
# Likes:    1845
# Dislikes: 0
# Total Accepted:    352.2K
# Total Submissions: 704.1K
# Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
#
# 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
# 个数字。滑动窗口每次只向右移动一位。
# 
# 返回 滑动窗口中的最大值 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
# 输出：[3,3,5,5,6,7]
# 解释：
# 滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# ⁠1 [3  -1  -3] 5  3  6  7       3
# ⁠1  3 [-1  -3  5] 3  6  7       5
# ⁠1  3  -1 [-3  5  3] 6  7       5
# ⁠1  3  -1  -3 [5  3  6] 7       6
# ⁠1  3  -1  -3  5 [3  6  7]      7
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [1], k = 1
# 输出：[1]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 1 <= k <= nums.length
# 
# 
#

# @lc code=start
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        wind = []
        res = []
        def ppush(x):
            if not wind:
                wind.append(x)
            else:
                while wind and wind[-1] < x:
                    wind.pop()
                wind.append(x)
        for i, x in enumerate(nums):
            if i < k-1:
                ppush(x)
            else:
                ppush(x)
                res.append(wind[0])
                if nums[i-k+1] == wind[0]:
                    wind.pop(0)
        return res



# @lc code=end

