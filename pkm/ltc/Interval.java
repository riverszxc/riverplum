/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: Interval 
 * @author riverz
 * @date 2017年9月12日 下午3:41:14
 * @Description:
 */
public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	public String toString(){
		return "["+start+","+end+"]";
	}
}
