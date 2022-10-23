#
# @lc app=leetcode.cn id=96 lang=python3
#
# [96] 不同的二叉搜索树
#
# https://leetcode.cn/problems/unique-binary-search-trees/description/
#
# algorithms
# Medium (70.77%)
# Likes:    1975
# Dislikes: 0
# Total Accepted:    307.1K
# Total Submissions: 433.9K
# Testcase Example:  '3'
#
# 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：n = 3
# 输出：5
# 
# 
# 示例 2：
# 
# 
# 输入：n = 1
# 输出：1
# 
# 
# 
# 
# 提示：
# 
# 
# 1 
# 
# 
#

# @lc code=start
class Solution:
    def numTrees(self, n: int) -> int:
        mem = [[0] * (n+1) for _ in range(n+1)]
        def count(l, r):
            if l >= r:
                return 1
            if mem[l][r] > 0:
                return mem[l][r]
            for i in range(l, r+1):
                ll = count(l, i-1)
                rr = count(i+1, r)
                mem[l][r] += ll * rr
            return mem[l][r]
        return count(1, n)
# @lc code=end

