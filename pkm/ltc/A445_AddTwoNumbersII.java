/**
 * 
 */
package me.riverz.leetcode;

import java.util.Stack;

/**
 * @ClassName: A445_AddTwoNumbersII
 * @author riverz
 * @date 2017年5月26日 下午1:33:43
 * @Description:You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * Tags: Linked List
 * Similar Problems (M) A002_Add Two Numbers
 */
public class A445_AddTwoNumbersII {

	/**@date 2017年5月26日 下午1:33:43*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(7);
		a.next = new ListNode(2);
		a.next.next = new ListNode(4);
		a.next.next.next = new ListNode(3);
		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);
		A445_AddTwoNumbersII a445 = new A445_AddTwoNumbersII();
		ListNode res = a445.addTwoNumbers(a, b);
		while(res!=null){
			System.out.print(res.val);
			res = res.next;
		}
	}
	
	/**@date 2017年5月26日 下午2:22:21*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1!=null){
        	st1.push(l1.val);
        	l1 = l1.next;
        }
        while(l2!=null){
        	st2.push(l2.val);
        	l2 = l2.next;
        }
        int carry = 0;
        ListNode res = new ListNode(0);
        //ListNode dog = res;
        while(!st1.isEmpty() || !st2.isEmpty() || carry!=0){
        	int sum = (st1.isEmpty()?0:st1.pop()) + (st2.isEmpty()?0:st2.pop()) + carry;
        	if(res.next == null)
        		res.next = new ListNode(sum%10);
        	else{
        		ListNode dog = new ListNode(sum%10);
        		dog.next = res.next;
        		res.next = dog;
        	}
        	carry = sum/10;
        }
        return res.next;
    }

}
