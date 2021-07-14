/**
 * 
 */
package me.riverz.leetcode;

import java.util.PriorityQueue;

/**
 * @ClassName: A023_MergekSortedLists 
 * @author riverz
 * @date 2017年6月9日 上午10:00:28
 * @Description:Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Tags: Divide and Conquer, Linked List, Heap
Similar Problems (E) A021_Merge Two Sorted Lists (M) A264_Ugly Number II
 */
public class A023_MergekSortedLists {

	/**@date 2017年6月9日 上午10:00:28
	 * @Description: */
	public static void main(String[] args) {
		
	}
	
    /**@date 2017年6月9日 上午10:03:23
     * @Description: lists为空则返回空*/
    public ListNode mergeKLists(ListNode[] lists) {   	
		return (lists!=null&&lists.length>0)?partition(lists,0,lists.length-1):null;
    }
    
    /**@date 2017年6月9日 上午10:59:00
     * @Description: 分治，两两递归合并*/
    private ListNode partition(ListNode[] lists,int lo,int hi){
    	if(lo==hi)
    		return lists[lo];
    	else{
    		int par=lo+(hi-lo)/2;//防止溢出的做法
    		ListNode l1 = partition(lists,lo,par);
    		ListNode l2 = partition(lists,par+1,hi);
    		return mergeTwoLists(l1,l2);
    	}
    }
    /**@date 2017年6月9日 上午10:59:04
     * @Description: 递归合并两个已排序链表*/
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
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
