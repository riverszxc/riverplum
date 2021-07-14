/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: A056_MergeIntervals 
 * @author rivers
 * @date 2017年9月12日 下午3:37:15
 * @Description:Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
Related Topics 
Array Sort 
Similar Questions 
(H) A057_Insert Interval  (E) Meeting Rooms (M) Meeting Rooms II  (M) A495_Teemo Attacking  (M) Add Bold Tag in String 
 */
public class A056_MergeIntervals {

	/**@date 2017年9月12日 下午3:37:16
	 * @Description: **/
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1,6),new Interval(2,3),new Interval(8,10),new Interval(15,18)));
		System.out.println(merge(intervals));
	}
    /**@date 2017年9月13日 上午10:24:52
     * @Description: 对intervals按start排序，遍历过程中动态替换start和end，若没有交叉则添加interval(start,end)，注意添加最后一个**/
    public static List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size()<=1) return intervals;
        intervals.sort((x,y)->Integer.compare(x.start,y.start));
        /*匿名内部类排序1
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval x, Interval y){
        		return Integer.compare(x.start, y.start);
        	}
        });*/
        /*匿名内部类排序2
        intervals.sort(new Comparator<Interval>(){
        	public int compare(Interval x, Interval y){
        		return Integer.compare(x.start, y.start);
        	}
        });*/
        List<Interval> res = new ArrayList<>();
        int start=intervals.get(0).start,end=intervals.get(0).end;
        for(Interval interval:intervals){
        	if(interval.start>=start&&interval.start<=end){
        		end=Math.max(end,interval.end);//这里要判断，防止出现[1,6],[2,3]
        	}else{
        		res.add(new Interval(start,end));
        		start=interval.start;
        		end = interval.end;
        	}
        }
        res.add(new Interval(start,end));
        return res;
    }

}


