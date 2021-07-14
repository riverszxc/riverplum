/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A048_SortList 
 * @author riverz
 * @date 2017年6月9日 上午11:44:51
 * @Description:Sort a linked list in O(n log n) time using constant space complexity.
Tags: Linked List, Sort
Similar Problems (E) A021_Merge Two Sorted Lists (M) A075_Sort Colors (M) A147_Insertion Sort List

 */
public class A048_SortList {

	/**@date 2017年6月9日 上午11:44:51
	 * @Description: */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(2);
		ListNode b = sortList(a);
		while(b!=null){
			System.out.print(b.val);
			b=b.next;
		}
	}
	
	/**@date 2017年6月9日 下午3:20:35
	 * @Description: 递归分治合并，但不符合常数空间复杂度的要求*/
	public static ListNode sortList(ListNode head) {
		//head==null是防止一开始就给了个空指针，递归过程中不会产生head==null的情况
		if(head==null || head.next==null)
			return head;
		ListNode pre=head,slow=head,fast=head;
		//slow一次走一步，fast一次走两步，fast走到尾时slow恰好在中间，将链表分开
		while(fast!=null && fast.next!=null){
			pre = slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		pre.next=null;//将链表一分为二
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);		
		return mergeTwoLists(l1,l2);
    }
	/**@date 2017年6月9日 下午3:27:04
	 * @Description: 递归合并两个已排序链表*/
	private static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val){
			l1.next = mergeTwoLists(l1.next,l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l1,l2.next);
			return l2;
		}
	}

}
