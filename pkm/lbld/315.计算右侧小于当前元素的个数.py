#
# @lc app=leetcode.cn id=315 lang=python3
#
# [315] 计算右侧小于当前元素的个数
#
# https://leetcode.cn/problems/count-of-smaller-numbers-after-self/description/
#
# algorithms
# Hard (43.10%)
# Likes:    908
# Dislikes: 0
# Total Accepted:    74.2K
# Total Submissions: 172.1K
# Testcase Example:  '[5,2,6,1]'
#
# 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
# nums[i] 的元素的数量。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：nums = [5,2,6,1]
# 输出：[2,1,1,0] 
# 解释：
# 5 的右侧有 2 个更小的元素 (2 和 1)
# 2 的右侧仅有 1 个更小的元素 (1)
# 6 的右侧有 1 个更小的元素 (1)
# 1 的右侧有 0 个更小的元素
# 
# 
# 示例 2：
# 
# 
# 输入：nums = [-1]
# 输出：[0]
# 
# 
# 示例 3：
# 
# 
# 输入：nums = [-1,-1]
# 输出：[0,0]
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        cnt = [0] * n
        nums_pair = [(i, x) for i, x in enumerate(nums)]
        temp = nums_pair[:]
        def sort(l, r):
            if l == r:
                return
            mid = l + (r - l) // 2
            sort(l, mid)
            sort(mid+1, r)
            x, i, j = l, l, mid+1
            while i <= mid or j <= r:
                if j > r or (i <= mid and nums_pair[i][1] <= nums_pair[j][1]):
                    cnt[nums_pair[i][0]] += j - mid - 1
                    temp[x] = nums_pair[i]
                    i += 1
                else:
                    temp[x] = nums_pair[j]
                    j += 1
                x += 1
            nums_pair[l:r+1] = temp[l:r+1]
        sort(0, n-1)
        return cnt

        
# @lc code=end

