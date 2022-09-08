#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第 N 个结点
#
# https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
#
# algorithms
# Medium (44.56%)
# Likes:    2194
# Dislikes: 0
# Total Accepted:    907K
# Total Submissions: 2M
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：head = [1,2,3,4,5], n = 2
# 输出：[1,2,3,5]
# 
# 
# 示例 2：
# 
# 
# 输入：head = [1], n = 1
# 输出：[]
# 
# 
# 示例 3：
# 
# 
# 输入：head = [1,2], n = 1
# 输出：[1]
# 
# 
# 
# 
# 提示：
# 
# 
# 链表中结点的数目为 sz
# 1 <= sz <= 30
# 0 <= Node.val <= 100
# 1 <= n <= sz
# 
# 
# 
# 
# 进阶：你能尝试使用一趟扫描实现吗？
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from ast import dump


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        # p1 = dummy
        # p2 = dummy
        # for i in range(n):
        #     p1 = p1.next
        # while p1.next:
        #     p1 = p1.next
        #     p2 = p2.next
        def findlastn(head, n):
            p1 = head
            for i in range(n):
                p1 = p1.next
            p2 = head
            while p1:
                p1 = p1.next
                p2 = p2.next
            return p2
        p2 = findlastn(dummy, n+1)
        p2.next = p2.next.next
        return dummy.next
        
# @lc code=end

