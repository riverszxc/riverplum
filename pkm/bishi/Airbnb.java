/**
 * 
 */
package me.riverz.bishi;
import java.util.*;
/**
 * @ClassName: Airbnb 
 * @author rivers
 * @date 2017年9月28日 下午9:31:09
 * @Description:
 */
public class Airbnb {

	/**@date 2017年9月28日 下午9:31:09
	 * @Description: */
	public static void main(String[] args) {
		/*
		Scanner in = new Scanner(System.in);
        
        int _counts_size = 0;
        _counts_size = Integer.parseInt(in.nextLine().trim());
        int[] _counts = new int[_counts_size];
        int _counts_item;
        for(int _counts_i = 0; _counts_i < _counts_size; _counts_i++) {
            _counts_item = Integer.parseInt(in.nextLine().trim());
            _counts[_counts_i] = _counts_item;
        }
        
        socialGraphs(_counts);*/
		socialGraphs(new int[]{2,2,2,2});
	}
	
	
	
	static int minMoves(int[][] maze, int x, int y) {
		int r = maze.length, c = maze[0].length;
		int[][] used = new int[r][c];
		int cheeses = 0;
		for(int[] i:maze){
			for(int j:i){
				if(j==2)
					cheeses++;
			}
		}
		List<Integer> paths = new ArrayList<>();
		dfs(cheeses,maze,used,0,0,0,x,y,paths,0);
		int min=Integer.MAX_VALUE;
		for(int p:paths){
			min = Math.min(min, p);
		}
		return min;
    }
	static void dfs(int cheeses, int[][] maze,int[][] used,int hascheese,int locatex,int locatey,int x,int y,List<Integer> paths,int path){
		if(locatex==x&&locatey==y){
			if(hascheese==cheeses)
				paths.add(path);
			return;
		}
		int[] nextlocate = next(used,maze,locatex,locatey);
		used[nextlocate[0]][nextlocate[1]] = 1;
		if(maze[nextlocate[0]][nextlocate[1]]==2)
			hascheese++;
		dfs(cheeses,maze,used,hascheese,nextlocate[0],nextlocate[1],x,y,paths,path+1);
		
	}
	static int[] next(int[][] used, int[][] maze, int locatex, int locatey){
		//时间不够了这个函数没写完
		if(locatey+1<maze[0].length && used[locatex][locatey+1]!=1&&maze[locatex][locatey+1]!=1){
			return new int[]{locatex,locatey+1};
		}
		return new int[]{};
	}
	
	
	
	public static void socialGraphs(int[] counts) {
        Map<Integer,Integer> index = new HashMap<>();//记录最后一个数量为x的组的下标
        List<List<Integer>> users = new ArrayList<>();
        for(int i=0;i<counts.length;i++){
        	if(counts[i]==1){
        		users.add(new ArrayList<Integer>());
        		users.get(users.size()-1).add(i);
        	}else{
        		if(index.containsKey(counts[i]) && users.get(index.get(counts[i])).size()<counts[i]){
    				users.get(index.get(counts[i])).add(i);
        		}else{
    				users.add(new ArrayList<Integer>());
    				users.get(users.size()-1).add(i);
    				index.put(counts[i], users.size()-1);
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(List<Integer> l:users){
        	for(int i:l){
        		sb.append(i);
        		sb.append(" ");
        	}
        	sb.setLength(sb.length()-1);
        	System.out.println(sb);
        	sb.setLength(0);
        }

    }

}
