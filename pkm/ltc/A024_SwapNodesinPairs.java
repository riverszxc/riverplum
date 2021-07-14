/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A024_SwapNodesinPairs 
 * @author riverz
 * @updateDate 2017年6月9日 下午4:06:03
 * @Description:Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
Tags: Linked List
Similar Problems (H) A025_Reverse Nodes in k-Group

 */
public class A024_SwapNodesinPairs {
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		A024_SwapNodesinPairs a24 = new A024_SwapNodesinPairs();

		a = a24.swapPairs(a);
		while(a!=null){
			System.out.print(a.val);
			a = a.next;
		}
	}
	
	/**@date 2017年6月9日 下午4:08:21
	 * @Description: */
	public ListNode swapPairs(ListNode head){
		if(head==null || head.next==null) 
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy, first, second;
		while(current.next!=null && current.next.next!=null){
			first = current.next;
			second = current.next.next;
			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = first;
		}
		return dummy.next;
	}

	/*Old Version:*/
	public ListNode swapPairs1(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode s = head,p=null, k;
		head = head.next;
		while(s!=null){
			if(s.next==null)
				break;
			if(p!=null)
				p.next = s.next;
			p = s;
			k = s.next.next;
			s.next.next = s;
			s = s.next;
			s.next.next=k;
			s=k;
		}
		
		return head;
        
    }

	

}
