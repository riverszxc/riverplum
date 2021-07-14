/**
 * 
 */
package me.riverz.bishi;

/**
 * @ClassName: Mssss 
 * @author rivers
 * @date 2017年9月6日 下午3:47:25
 * @Description:
 */
public class Mssss {

	/**@date 2017年9月6日 下午3:47:25
	 * @Description: */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int atoi(String str) {
		if(str.equals("")) return -1;
		long sum=0;
		int sig=1;
		char[] c = str.toCharArray();
		int i=0;
		while(c[i]==' ') ++i;
		if(c[i]=='+'){
			sig = 1;
			++i;
		}else if(c[i]=='-'){
			sig=-1;
			++i;
		}
		for(;i<c.length;i++){
			if(c[i]>='0' && c[i]<='9'){
				sum = sum*10 + (c[i]-'0');
			}else
				break;
			if(sum*sig>Integer.MAX_VALUE)
				return -1;
			else if(sum*sig<Integer.MIN_VALUE)
				return -1;
		}
		sum*=sig;
		return (int)sum;
	}
	
	
	public static int myAtoi(String str) {
		if(str.equals("")) return 0;
		long sum=0;
		int sig=1;
		char[] c = str.toCharArray();
		int i=0;
		while(c[i]==' ') ++i;
		if(c[i]=='+'){ 
			sig=1;
			++i;
		}
		else if(c[i]=='-'){ 
			sig=-1;
			++i;
		}
		for(; i<c.length; i++){
			if(c[i]>='0' && c[i]<='9'){
				sum = sum*10 + (c[i]-'0'); //既然可以与'0''9'比大小，那么就可以利用c[i]-'0'直接将字符转换为数字
			}else
				break;//题目要求不符合格式直接返回0
			if(sum*sig>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if(sum*sig<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		sum*=sig;
		return (int)sum;
    }
	
	/*Old Version*/
	public static int myAtoi1(String str) {
		long sum=0;
		int sig=1;
		char[] c = str.toCharArray();
		int i=0;
		
		if(str.equals("")) return 0;
		
		while(c[i]==' ') ++i;
		if(c[i]=='+'){ 
			sig=1;
			++i;
		}
		else if(c[i]=='-'){ 
			sig=-1;
			++i;
		}
		for(; i<c.length; i++){
			if(c[i]>='0' && c[i]<='9'){
				switch(c[i]){
				case '0':
					sum = sum*10 + 0;
					break;
				case '1':
					sum = sum*10 + 1;
					break;
				case '2':
					sum = sum*10 + 2;
					break;
				case '3':
					sum = sum*10 + 3;
					break;
				case '4':
					sum = sum*10 + 4;
					break;
				case '5':
					sum = sum*10 + 5;
					break;
				case '6':
					sum = sum*10 + 6;
					break;
				case '7':
					sum = sum*10 + 7;
					break;
				case '8':
					sum = sum*10 + 8;
					break;
				case '9':
					sum = sum*10 + 9;
					break;
				}
			}else
				break;
			if(sum*sig>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if(sum*sig<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		sum*=sig;
		
		return (int)sum;
        
    }

}
