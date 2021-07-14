package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: A022_GenerateParentheses 
 * @author riverz
 * @updateDate 2017年6月5日 下午3:26:33
 * @Description:Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
Tags： Backtracking， String
Similar Problems (M) A017_Letter Combinations of a Phone Number (E) A020_Valid Parentheses

 */
public class A022_GenerateParentheses {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A022_GenerateParentheses a022 = new A022_GenerateParentheses();
		
		long startTime=System.currentTimeMillis();
		List<String> list = a022.generateParenthesis1(4);
		long endTime=System.currentTimeMillis();
		System.out.println("耗时:"+(endTime-startTime)+"ms");
		
		for(String s:list)
			System.out.println(s);
	}
	
	/**@date 2017年6月5日 下午3:52:43
	 * @Description: 在回溯过程中使用一个StringBuilder对象的增删比直接用String节省一倍时间*/
	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();//适用StringBuilder代替String节省时间空间
		generate_new(n,n,sb,res);
		return res;
	}
	private void generate_new(int l,int r,StringBuilder sb,List<String> res){
		if(l==0 && r==0)
			res.add(sb.toString());
		if(l>0){
			generate_new(l-1,r,sb.append("("),res);//注意这里传的参数不是--l,而是l-1
			sb.deleteCharAt(sb.length()-1);
		}
		if(r>l){
			generate_new(l,r-1,sb.append(")"),res);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	/*Old Version:*/
	public List<String> generateParenthesis1(int n) {
		
		List<String> list = new ArrayList<String>();
		String s = "";
		generate(n,n,s,list);
		return list;
    }
	public void generate(int l, int r, String s, List<String> list){
		if(l==0&&r==0)
			list.add(s);
		if(l>0)
			generate(l-1,r,s+"(",list);
		if(r>0&&r>l)
			generate(l,r-1,s+")",list);
	}
	
	
	

}
