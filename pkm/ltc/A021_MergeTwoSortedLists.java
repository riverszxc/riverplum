/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A021_MergeTwoSortedLists 
 * @author riverz
 * @updateDate 2017年6月9日 上午9:34:39
 * @Description:Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
Tags： Linked List
Similar Problems (H) A023_Merge k Sorted Lists (E) A088_Merge Sorted Array (M) A148_Sort List (M) Shortest Word Distance II

 */
public class A021_MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**@date 2017年6月9日 上午9:50:49
	 * @Description: 递归，返回当前最小节点*/
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
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
	
	
	
	
	/*Old Version:循环*/
	public static  ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l = head;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				l.next = l1;
				l1 = l1.next;
			}else{
				l.next = l2;
				l2 = l2.next;
			}
			l = l.next;
		}
		if(l1!=null)
			l.next = l1;
		if(l2!=null)
			l.next = l2;
			
		return head.next;
        
    }
	
	

}
