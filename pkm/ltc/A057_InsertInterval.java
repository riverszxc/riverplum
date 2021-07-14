/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: A057_InsertInterval 
 * @author riverz
 * @date 2017年9月13日 上午11:33:27
 * @Description:Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Related Topics 
Array Sort 
Similar Questions 
(M) A056_Merge Intervals 
 */
public class A057_InsertInterval {

	/**@date 2017年9月13日 上午11:33:27
	 * @Description: */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1,2),new Interval(3,5),new Interval(6,7),new Interval(8,10),new Interval(12,16)));
		System.out.println(insert(intervals,new Interval(4,9)));

	}
	
    /**@date 2017年9月13日 上午11:33:38
     * @Description: */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(newInterval==null) return intervals;
    	List<Interval> res = new ArrayList<>();
    	for(Interval interval:intervals){
        	if(newInterval==null || interval.end<newInterval.start){//置空表明newInterval已经被插入,依次插入其他的即可
        		res.add(interval);
        	}else if(interval.start>newInterval.end){
        		res.add(newInterval);
        		newInterval=null;//置空用来表明newInterval已经被插入
        		res.add(interval);
        	}else{
        		newInterval.start = Math.min(interval.start, newInterval.start);
        		newInterval.end = Math.max(interval.end, newInterval.end);
        	}
        }
    	if(newInterval!=null)
    		res.add(newInterval);
    	return res;
    }

}
