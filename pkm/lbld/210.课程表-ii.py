#
# @lc app=leetcode.cn id=210 lang=python3
#
# [210] 课程表 II
#
# https://leetcode.cn/problems/course-schedule-ii/description/
#
# algorithms
# Medium (56.18%)
# Likes:    698
# Dislikes: 0
# Total Accepted:    150K
# Total Submissions: 267K
# Testcase Example:  '2\n[[1,0]]'
#
# 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中
# prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
# 
# 
# 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
# 
# 
# 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：numCourses = 2, prerequisites = [[1,0]]
# 输出：[0,1]
# 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
# 
# 
# 示例 2：
# 
# 
# 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
# 输出：[0,2,1,3]
# 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
# 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
# 
# 示例 3：
# 
# 
# 输入：numCourses = 1, prerequisites = []
# 输出：[0]
# 
# 
# 
# 提示：
# 
# 
# 1 <= numCourses <= 2000
# 0 <= prerequisites.length <= numCourses * (numCourses - 1)
# prerequisites[i].length == 2
# 0 <= ai, bi < numCourses
# ai != bi
# 所有[ai, bi] 互不相同
# 
# 
#

# @lc code=start
from itertools import cycle


class Solution:
    # def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
    #     graph = [[] for _ in range(numCourses)]
    #     for after, before in prerequisites:
    #         graph[after].append(before)
    #     res = []
    #     visit = [False] * numCourses
    #     inpath = [False] * numCourses
    #     cycle = False
    #     def traverse(v):
    #         nonlocal cycle
    #         if inpath[v]:
    #             cycle = True
    #             return
    #         if cycle or visit[v]:
    #             return
    #         inpath[v] = True
    #         visit[v] = True
    #         for x in graph[v]:
    #             traverse(x)
    #         res.append(v)
    #         inpath[v] = False
            
    #     for v in range(numCourses):
    #         if not cycle:
    #             traverse(v)
    #     return res if not cycle else []
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for after, before in prerequisites:
            graph[before].append(after)
            indegree[after] += 1
        res = []
        cnt = 0
        zero = []
        for i, ind in enumerate(indegree):
            if ind == 0:
                cnt += 1
                zero.append(i)
        while zero:
            v = zero.pop()
            res.append(v)
            for x in graph[v]:
                indegree[x] -= 1
                if indegree[x] == 0:
                    cnt += 1
                    zero.append(x)
        return res if cnt == numCourses else []


# @lc code=end

