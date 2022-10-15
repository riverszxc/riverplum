#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] 排序链表
#
# https://leetcode.cn/problems/sort-list/description/
#
# algorithms
# Medium (66.18%)
# Likes:    1804
# Dislikes: 0
# Total Accepted:    353.1K
# Total Submissions: 533.7K
# Testcase Example:  '[4,2,1,3]'
#
# 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
# 
# 
# 
# 
# 
# 
# 示例 1：
# 
# 
# 输入：head = [4,2,1,3]
# 输出：[1,2,3,4]
# 
# 
# 示例 2：
# 
# 
# 输入：head = [-1,5,3,4,0]
# 输出：[-1,0,3,4,5]
# 
# 
# 示例 3：
# 
# 
# 输入：head = []
# 输出：[]
# 
# 
# 
# 
# 提示：
# 
# 
# 链表中节点的数目在范围 [0, 5 * 10^4] 内
# -10^5 <= Node.val <= 10^5
# 
# 
# 
# 
# 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from re import L


class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        pre = slow = fast = head
        while fast and fast.next:
            pre = slow
            slow = slow.next
            fast = fast.next.next
        pre.next = None
        l1 = head
        l2 = slow
        def merge(l, r):
            pp = ListNode()
            p = pp
            while l and r:
                if l.val < r.val:
                    p.next = l
                    l = l.next
                else:
                    p.next = r
                    r = r.next
                p = p.next
            p.next = l if l else r
            return pp.next
        return merge(self.sortList(l1), self.sortList(l2))
# @lc code=end

