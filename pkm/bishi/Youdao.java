/**
 * 
 */
package me.riverz.bishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: Youdao 
 * @author rivers
 * @date 2017年9月9日 下午3:42:49
 * @Description:
 */
public class Youdao {

	/**@date 2017年9月9日 下午3:42:49
	 * @Description: */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), L = in.nextInt();
        int[][] adj = new int[n][n];
        int[] par = new int[n];
        
        for(int i=1;i<n;i++){
        	par[i] = in.nextInt();
        	adj[par[i]][i]=1;
        }
        int num1=1,num2=1, maxnum=1;
    	boolean used[] = new boolean[n];
    	used[0] = true;
    	
    	
    	
    	Stack<Integer> st = new Stack<>();
    	st.push(0);
    	while(!st.isEmpty()){
    		int v = getAdjUnused(st.peek(), adj, used);
    		if(v == -1){
    			st.pop();
    			num1--;
    			num2++;
    		}else if(num2<=L ){
    			used[v] = true;
    			num1++;
    			num2++;
    			maxnum = Math.max(maxnum, Math.max(num2, num1));
    			st.push(v);
    		}
    		else if(num1<=L){
    			used[v] = true;
    			num1++;
    			maxnum = Math.max(maxnum, num1);
    			st.push(v);
    		}
    	}
        System.out.println(maxnum);
    }
    
    public static int getAdjUnused(int v, int[][] adj, boolean[] used){
        for(int i = 0; i < adj.length; i++){
            if(adj[v][i] == 1 && used[i] == false){
                return i;
            }
        }
        return -1;
    }

}
