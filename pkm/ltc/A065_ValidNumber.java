/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A065_ValidNumber 
 * @author rivers
 * @date 2017年6月3日 下午8:28:54
 * @Description:Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
Tags: Math, String
Similar Problems (M) A008_String to Integer (atoi)

 */
public class A065_ValidNumber {

	/**@date 2017年6月3日 下午8:28:54
	 * @Description: */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ".12e+1";
		System.out.println(isNumber(s));
	}
	
	/**@date 2017年6月3日 下午8:31:04
	 * @Description: */
	public static boolean isNumber(String s) {
		s=s.trim();
		if(s.equals("")) return false;
	    boolean num = false;
	    boolean point = false;
	    boolean e = false;
	    
	    for(int i=0;i<s.length();i++){
	    	if(s.charAt(i)>='0' && s.charAt(i)<='9'){
	    		num = true;
	    	}else if(s.charAt(i)=='.'){
	    		if(point || e || num==false&&i==s.length()-1)//多个小数点，e后小数点，只有小数点
	    			return false;
	    		point = true;
	    	}else if(s.charAt(i)=='e'){
	    		if(e || num==false || i==s.length()-1)//多个e，e前没数字，e在最后
	    			return false;
	    		e = true;
	    	}else if(s.charAt(i)=='-' || s.charAt(i)=='+'){
	    		if((i!=0&&s.charAt(i-1)!='e') || i==s.length()-1)//不在首位并且不在e后面，出现在最后
	    			return false;
	    	}else
	    		return false;
	    }
	    return true;
    }

}
