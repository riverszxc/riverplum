/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: A301_RemoveInvalidParentheses 
 * @author riverz
 * @date 2017年6月7日 下午8:59:14
 * @Description:Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).
Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
Tags: Depth-first Search, Breadth-first Search
Similar Problems (E) A020_Valid Parentheses

 */
public class A301_RemoveInvalidParentheses {

	/**@date 2017年6月7日 下午8:59:14
	 * @Description: 两种解决方法*/
	public static void main(String[] args) {
		String s = ")(a";//()())() ())())  ()())   (())  ()()
		List<String> res = removeInvalidParentheses(s);
		for(String r:res)
			System.out.println(r);
	}
	
    /**@date 2017年6月7日 下午9:01:06
     * @Description: 分别计算出多余的"("和多余的")",递归调用生成函数*/
    public static List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<>();
    	/*必须分别计算多余的正括号数量和多余的反括号数量，比如")()("，balance==0
		int balance=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(') balance++;
			else if(s.charAt(i)==')') balance--;
		}
		*/
    	int morel=0,morer=0;
    	//分别计算出多余的"("和多余的")"
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='(') morel++;
    		else if(s.charAt(i)==')')
    			if(morel>0) morel--;
    			else morer++;
    	}
    	generate(0,res,new StringBuilder(s),new StringBuilder(),morel,morer,0,' ');
    	return res;
    }
    /**@date 2017年6月8日 下午7:38:37
     * @Description: 从头到尾遍历生成新的括号对，按用或不用当前括号分别进行递归
     * i:遍历原字符串索引
     * s:原字符串生成的StringBuilder对象 
     * morel,morer:多余的正反括号数
     * sb:当前动态生成的字符串 
     * valid:当前动态生成的字符串sb的平衡参数
     * lastuse:前一个使用的括号*/
    private static void generate(int i,List<String> res,StringBuilder s, StringBuilder sb, int morel,int morer, int valid,char lastuse){
    	if(i==s.length()){ 
    		if(valid==0 && morel==0 && morer==0)
    			res.add(sb.toString());
    		return;
		}
    	if(valid<0 || morel<0 || morer<0)
    		return;
    	int len=sb.length();
    	if(s.charAt(i)=='('){
    		//前一个使用的不是正括号时才可以选择不用，
    		//即前一个使用的是正括号，则本次正括号必须用，若这次不用，那么就与上次也不用的情况重复，出现重复答案
    		//两个挨边的相同括号，要么都用，要么都不用，要么用一个，那么用一个的情况为了避免重复，我取用后面的，即前面用了后面也得用
    		if(lastuse!='(')
    			generate(i+1,res,s,sb,morel-1,morer,valid,' ');
    		generate(i+1,res,s,sb.append('('),morel,morer,valid+1,'(');
    	}else if(s.charAt(i)==')'){
    		if(lastuse!=')')//只有前一个使用的不是反括号时才可以选择不用
    			generate(i+1,res,s,sb,morel,morer-1,valid,' ');
    		generate(i+1,res,s,sb.append(')'),morel,morer,valid-1,')');
    	}else{
    		generate(i+1,res,s,sb.append(s.charAt(i)),morel,morer,valid,' ');
    	}
    	sb.setLength(len);//本次结束，将本次增加的字符去掉
    }
    
    
    /**@date 2017年6月7日 下午10:29:29
     * @Description: 外层for循环只用来过滤当前last_i开始的字符串的par[0]和与之数量匹配的par[1]，一旦遇到多余的par[1]就进入下级递归，
     * 下级递归return后，即等内层for循环完，就已经找到所有答案，直接return
     * i从last_j遍历到发现多余反括号，j从last_j遍历到第一个要去除的位置*/
    public static List<String> removeInvalidParentheses1(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    public static void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

}
