#
# @lc app=leetcode.cn id=207 lang=python3
#
# [207] 课程表
#
# https://leetcode.cn/problems/course-schedule/description/
#
# algorithms
# Medium (53.90%)
# Likes:    1415
# Dislikes: 0
# Total Accepted:    247.2K
# Total Submissions: 458.6K
# Testcase Example:  '2\n[[1,0]]'
#
# 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
# 
# 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
# ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
# 
# 
# 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
# 
# 
# 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：numCourses = 2, prerequisites = [[1,0]]
# 输出：true
# 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
# 
# 示例 2：
# 
# 
# 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
# 输出：false
# 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
# 
# 
# 
# 提示：
# 
# 
# 1 
# 0 
# prerequisites[i].length == 2
# 0 i, bi < numCourses
# prerequisites[i] 中的所有课程对 互不相同
# 
# 
#

# @lc code=start
class Solution:
    # def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    #     graph = [[] for _ in range(numCourses)]
    #     for after, before in prerequisites:
    #         graph[before].append(after)
    #     cycle = False
    #     path = set()
    #     visit = set()
    #     def traverse(v):
    #         nonlocal cycle
    #         if v in path:
    #             cycle = True
    #             return
    #         if cycle or v in visit:
    #             return
    #         path.add(v)
    #         visit.add(v)
    #         for x in graph[v]:
    #             traverse(x)
    #         path.remove(v)
    #     for v in range(numCourses):
    #         if not cycle:
    #             traverse(v)
    #     return not cycle
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        graph = [[] for _ in range(numCourses)]
        for after, before in prerequisites:
            graph[before].append(after)
            indegree[after] += 1
        zerodegrees = []
        cnt = 0
        for i, ind in enumerate(indegree):
            if ind == 0:
                cnt += 1
                zerodegrees.append(i)
        while zerodegrees:
            z = zerodegrees.pop()
            for x in graph[z]:
                indegree[x] -= 1
                if indegree[x] == 0:
                    cnt += 1
                    zerodegrees.append(x)
        return cnt == numCourses
            

# @lc code=end

