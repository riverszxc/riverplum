/**
 * 
 */
package me.riverz.bishi;

/**
 * @ClassName: Ali1 
 * @author rivers
 * @date 2017年8月25日 下午7:48:29
 * @Description:
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int minTravelTime(int N, int[][] intersections, int M, int[][] roads, int s, int t) {
    	
    	int[][] weight = new int[N][N];
    	for(int i=0;i<N;i++){
    		for(int j=0;j<N;j++){
    			if(i!=j){
    				weight[i][j]=Integer.MAX_VALUE;
    			}
    		}
    	}
    	for(int[] x:roads){
    		weight[x[0]][x[1]]=x[2];
    	}
    	
    	int[] shortPath = new int[N];
    	int[] visited = new int[N];
    	shortPath[s] = 0;
    	visited[s] = 1;
    	for(int count = 1;count<=N-1;count++){
    		int k=-1;
    		int mindis = Integer.MAX_VALUE;
    		for(int i=0;i<N;i++){
    			if(visited[i]==0){
    				int stoptime=(mindis%(intersections[i][1]*2))<intersections[i][1]?0:(intersections[i][1]*2-mindis%(intersections[i][1]*2));
    				if(weight[s][i]+stoptime<mindis){
    					mindis = weight[s][i];
    					k=i;
    				}
    			}
    		}
    		shortPath[k]=mindis;
    		visited[k]=1;
    		
    		for(int i=0;i<N;i++){
    			if(visited[i]==0){
    				//s到k的时间不变，但是k到i的时间要变了，怎么算？
    				int stoptime=(weight[s][k]%(intersections[k][1]*2))<intersections[k][1]?0:(intersections[k][1]*2-weight[s][k]%(intersections[k][1]*2));
    				if(weight[s][k]+weight[k][i]+stoptime<weight[s][i]){
    					weight[s][i] = weight[s][k]+weight[k][i]+stoptime;
    				}
    			}
    		}
    	}
    	
		return weight[s][t];
    }

     public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());



        int _intersections_rows = 0;
        int _intersections_cols = 0;
        _intersections_rows = _N;
        _intersections_cols = 2;

        int[][] _intersections = new int[_intersections_rows][_intersections_cols];
        for(int _intersections_i=0; _intersections_i<_intersections_rows; _intersections_i++) {
            String tempLine = in.nextLine().trim();
            String[] _intersectionStrs = tempLine.split(",");
            for(int _intersections_j=0; _intersections_j<_intersections_cols; _intersections_j++) {
                _intersections[_intersections_i][_intersections_j] = Integer.parseInt(_intersectionStrs[_intersections_j]);

            }
        }


        int _M;
        _M = Integer.parseInt(in.nextLine().trim());

        int _roads_rows = 0;
        int _roads_cols = 0;
        _roads_rows = _M;
        _roads_cols = 3;

        int[][] _roads = new int[_roads_rows][_roads_cols];
        for(int _roads_i=0; _roads_i<_roads_rows; _roads_i++) {
            String tempLine = in.nextLine().trim();
            String[] _roadStrs = tempLine.split(",");
            for(int _roads_j=0; _roads_j<_roads_cols; _roads_j++) {
                _roads[_roads_i][_roads_j] = Integer.parseInt(_roadStrs[_roads_j].trim());

            }
        }

        String stLine = in.nextLine().trim();
        String[] s_t_str = stLine.split(",");
        int _s;
        _s = Integer.parseInt(s_t_str[0]);

        int _t;
        _t = Integer.parseInt(s_t_str[1]);

       res = minTravelTime(_N, _intersections, _M, _roads, _s, _t);
       System.out.println(res);
     }
}
