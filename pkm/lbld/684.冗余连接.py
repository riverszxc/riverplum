#
# @lc app=leetcode.cn id=684 lang=python3
#
# [684] 冗余连接
#
# https://leetcode.cn/problems/redundant-connection/description/
#
# algorithms
# Medium (67.39%)
# Likes:    502
# Dislikes: 0
# Total Accepted:    82.4K
# Total Submissions: 122.3K
# Testcase Example:  '[[1,2],[1,3],[2,3]]'
#
# 树可以看成是一个连通且 无环 的 无向 图。
# 
# 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n
# 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和
# bi 之间存在一条边。
# 
# 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
# 
# 
# 
# 示例 1：
# 
# 
# 
# 
# 输入: edges = [[1,2], [1,3], [2,3]]
# 输出: [2,3]
# 
# 
# 示例 2：
# 
# 
# 
# 
# 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
# 输出: [1,4]
# 
# 
# 
# 
# 提示:
# 
# 
# n == edges.length
# 3 
# edges[i].length == 2
# 1 
# ai != bi
# edges 中无重复元素
# 给定的图是连通的 
# 
# 
#

# @lc code=start
from curses import nonl


class Solution:
    # def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
    #     cluster = [x for x in range(len(edges)+1)]
    #     def findcluster(node):
    #         nonlocal cluster
    #         if cluster[node] != node:
    #             return findcluster(cluster[node])
    #         return cluster[node]
    #     def mergecluster(node1, node2):
    #         nonlocal cluster
    #         cluster[findcluster(node1)] = cluster[findcluster(node2)]
    #     for node1, node2 in edges:
    #         if findcluster(node1) != findcluster(node2):
    #             mergecluster(node1, node2)
    #         else:
    #             return [node1, node2]
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        cluster = [i for i in range(len(edges)+1)]
        def findcluster(node):
            if cluster[node] == node:
                return node
            return findcluster(cluster[node])
        def merge(a, b):
            cluster[findcluster(a)] = findcluster(b)
        for a, b in edges:
            if findcluster(a) != findcluster(b):
                merge(a, b)
            else:
                return [a, b]

# @lc code=end

