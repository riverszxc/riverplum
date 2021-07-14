/**
 * 
 */
package me.riverz.leetcode;

/**
 * @author rivers
 * @description You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */
//UPDATE20170326:
//	You are given two non-empty linked lists representing two non-negative integers. 
//	The digits are stored in reverse order and each of their nodes contain a single digit. 
//	Add the two numbers and return it as a linked list.
//			You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//			Output: 7 -> 0 -> 8
//Tags: Linked List Math
//Similar Problems (M) A043_Multiply Strings (E) A067_Add Binary (E) A371_Sum of Two Integers (E) A415_Add Strings (M) A445_Add Two Numbers II


public class A002_AddTwoNumbers {

//20170326
	static public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode node3 = new ListNode(0);
		ListNode node3t = node3;
		int carry = 0;
		while(l1!=null || l2!=null || carry!=0){
			ListNode node3tn = new ListNode(0);
			int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
			node3tn.val = sum%10;
			carry = sum/10;
			l1 = l1==null?l1:l1.next;
			l2 = l2==null?l2:l2.next;
			node3t.next = node3tn;
			node3t = node3tn;
		}
		return node3.next;
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(8);
		//node1.next.next = new ListNode(3);
		
		ListNode node2 = new ListNode(1);
		//node2.next = new ListNode(6);
		//node2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(node1,node2);
		while(null != l3){
			System.out.println(l3.val);
			l3 = l3.next;
		}

	}
	
	
	
//	Old Version:
//	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		ListNode node3 = new ListNode(0);
//		ListNode node3t = node3;
//		int jinwei = 0;
//		while(null != l1 && null != l2){
//			int x = l1.val+l2.val;
//			if(x+jinwei>=10){
//				node3t.val = x+jinwei-10;
//				jinwei=1;
//			}else{
//				node3t.val = x+jinwei;
//				jinwei=0;
//			}
//			l1 = l1.next;
//			l2 = l2.next;
//			if(null != l1 || null != l2 ||jinwei==1)
//				node3t.next = new ListNode(0);
//			node3t = node3t.next;
//		}
//		while(null != l1){
//			int x = l1.val;
//			if(x+jinwei>=10){
//				node3t.val = x+jinwei-10;
//				jinwei=1;
//			}else{
//				node3t.val = x+jinwei;
//				jinwei=0;
//			}
//			l1 = l1.next;
//			if(null != l1 ||jinwei==1)
//				node3t.next = new ListNode(0);
//			node3t = node3t.next;
//		}
//		while(null != l2){
//			int x = l2.val;
//			if(x+jinwei>=10){
//				node3t.val = x+jinwei-10;
//				jinwei=1;
//			}else{
//				node3t.val = x+jinwei;
//				jinwei=0;
//			}
//			l2 = l2.next;
//			if(null != l2 ||jinwei==1)
//				node3t.next = new ListNode(0);
//			node3t = node3t.next;
//		}
//		if(jinwei==1){
//			node3t.val=1;
//		}
//		
//		return node3;
//        
//    }
	

	

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
