#
# @lc app=leetcode.cn id=92 lang=python3
#
# [92] 反转链表 II
#
# https://leetcode.cn/problems/reverse-linked-list-ii/description/
#
# algorithms
# Medium (55.57%)
# Likes:    1388
# Dislikes: 0
# Total Accepted:    335.8K
# Total Submissions: 604.4K
# Testcase Example:  '[1,2,3,4,5]\n2\n4'
#
# 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
# 反转后的链表 。
# 
# 
# 示例 1：
# 
# 
# 输入：head = [1,2,3,4,5], left = 2, right = 4
# 输出：[1,4,3,2,5]
# 
# 
# 示例 2：
# 
# 
# 输入：head = [5], left = 1, right = 1
# 输出：[5]
# 
# 
# 
# 
# 提示：
# 
# 
# 链表中节点数目为 n
# 1 
# -500 
# 1 
# 
# 
# 
# 
# 进阶： 你可以使用一趟扫描完成反转吗？
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # if left == right:
        #     return head
        # cur = head
        # a, b, c, d = None, None, None, None
        # prev = None
        # for i in range(1, right+1):
        #     if i == left - 1:
        #         a = cur
        #     if i == left:
        #         b = cur
        #     if i == right:
        #         c = cur
        #         d = c.next
        #         if a:
        #             a.next = c
        #         b.next = d
        #     if i >= left and i <= right:
        #         next = cur.next
        #         cur.next = prev
        #         prev = cur
        #         cur = next
        #         continue
        #     cur = cur.next
        # return head if left > 1 else c
        if left == 1:
            suffix1 = head
            for i in range(right-1):
                suffix1 = suffix1.next
            suffix2 = suffix1.next
            pre, cur = suffix2, head
            while cur != suffix2:
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            return pre
        else:
            head.next = self.reverseBetween(head.next, left-1, right-1)
            return head
# @lc code=end

