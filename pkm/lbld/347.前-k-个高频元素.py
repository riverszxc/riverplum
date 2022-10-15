#
# @lc app=leetcode.cn id=347 lang=python3
#
# [347] 前 K 个高频元素
#
# https://leetcode.cn/problems/top-k-frequent-elements/description/
#
# algorithms
# Medium (63.37%)
# Likes:    1350
# Dislikes: 0
# Total Accepted:    359.7K
# Total Submissions: 567.5K
# Testcase Example:  '[1,1,1,2,2,3]\n2'
#
# 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
# 
# 
# 
# 示例 1:
# 
# 
# 输入: nums = [1,1,1,2,2,3], k = 2
# 输出: [1,2]
# 
# 
# 示例 2:
# 
# 
# 输入: nums = [1], k = 1
# 输出: [1]
# 
# 
# 
# 提示：
# 
# 
# 1 
# k 的取值范围是 [1, 数组中不相同的元素的个数]
# 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
# 
# 
# 
# 
# 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
# 
#

# @lc code=start
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        def partition(l, r):
            t = random.randint(l, r)
            pivot = freqv[t][1]
            freqv[l], freqv[t] = freqv[t], freqv[l]
            ll, rr = l + 1, r
            while ll <= rr:
                while ll < r and freqv[ll][1] <= pivot:
                    ll += 1
                while rr > l and freqv[rr][1] > pivot:
                    rr -= 1
                if ll >= rr:
                    break
                freqv[ll], freqv[rr] = freqv[rr], freqv[ll]
            freqv[rr], freqv[l] = freqv[l], freqv[rr]
            return rr
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        freqv = []
        for pair in freq.items():
            freqv.append(pair)
        n = len(freqv)
        l, r = 0, n-1
        kk = n - k
        while l <= r:
            p = partition(l, r)
            if p == kk:
                return [x[0] for x in freqv[p:]]
            elif p < kk:
                l = p + 1
            else:
                r = p - 1

# @lc code=end

