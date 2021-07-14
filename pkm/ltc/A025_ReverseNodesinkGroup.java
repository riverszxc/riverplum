/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A025_ReverseNodesinkGroup 
 * @author riverz
 * @date 2017年6月9日 下午4:35:46
 * @Description:Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
Tags: Linked List
Similar Problems (M) A024_Swap Nodes in Pairs

 */
public class A025_ReverseNodesinkGroup {

	/**@date 2017年6月9日 下午4:35:46
	 * @Description: */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		ListNode res = reverseKGroup(a,5);
		while(res!=null){
			System.out.print(res.val);
			res = res.next;
		}

	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k==1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev=dummy, last=head, current=last.next, point=head, pointnext;
		//头插法逆转链表，prev指向当前链表前面的节点，头插的节点插入到prev之后，last指向已逆转节点的最后一个节点，
		//cur指向当前待头插节点,游标point从待头插节点位置递增到当前待逆转段最后一个节点的后一个位置
		for(int i=1;point!=null;i++){
//			System.out.println(prev.val+","+current.val+","+last.val+","+point.val);
			if(i%k==0){
				pointnext = point.next;
				while(current!=pointnext){
//					System.out.println("while:"+prev.val+","+current.val+","+last.val+","+point.val);
					last.next=current.next;
					current.next=prev.next;
					prev.next=current;
					current=last.next;
				}
				prev=last;
				last = last.next;
				if(last!=null)
					current=last.next;
				point=last;
			}else
				point=point.next;
		}
		
		return dummy.next;
    }

}
