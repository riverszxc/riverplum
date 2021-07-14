/**
 * 
 */
package me.riverz.bishi;

import java.util.Scanner;

/**
 * @ClassName: Didi 
 * @author riverz
 * @date 2017年9月23日 下午6:58:46
 * @Description:
 */
public class Didi {

	/**@date 2017年9月23日 下午6:58:46
	 * @Description: */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.nextLine().split(" ");
			String r = s[0];
			int n = Integer.valueOf(s[1]);
			
			StringBuilder res=new StringBuilder("1");
			int pointindex = 0;
			if(r.contains(".")){
				pointindex = r.length()-r.indexOf(".")-1;
				r = r.replace(".", "");
			}
			for(int i=1;i<=n;i++){
				res = multiply(res,r);
			}
			if(pointindex!=0){
				pointindex = pointindex*n;
				System.out.println(res.substring(0, res.length()-pointindex)+"."+res.substring(res.length()-pointindex));
				continue;
			}
			System.out.println(res);
	
		}

	}
	public static StringBuilder multiply(StringBuilder num1,String num2){
		int a = num1.length();
		int b = num2.length();
		int carry = 0;
		char[] res = new char[a+b];
		for(int i=0;i<a+b;i++)
			res[i]='0';
		for(int j=b-1; j>=0; j--){
			carry = 0;
			for(int i=a-1; i>=0; i--){
				int x = (num2.charAt(j)-'0') * (num1.charAt(i)-'0') + (res[i+j+1]-'0') + carry;//利用-'0'将char转为数字
				res[i+j+1] = (char) (x%10 + '0');
				carry = x/10;
			}
			res[j] = (char) (carry+'0');
		}
		if(res[0]=='0') return new StringBuilder(new String(res).substring(1));
        return new StringBuilder(new String(res));
	}

}
