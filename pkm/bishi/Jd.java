package me.riverz.bishi;

import java.util.Scanner;

/**
 * @ClassName: Jd 
 * @author rivers
 * @date 2017年9月8日 下午8:03:18
 * @Description:
 */
public class Jd {

//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//        long a = in.nextLong();
//        long k=1,i=0;
//        while(i<a){
//        	i=k*(k+1)/2;
//        	k++;
//        }
//        System.out.println(--k);
//
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong(),k=0;;
		
		for(int i=2;i<=a;i++){
			for(int j=1;j<=a;j++){
				for(int m=1;m<=a;m++){
					for(int n=1;n<=a;n++){
						if(Math.pow(i, j)==Math.pow(m, n)){
							k++;
							break;
						}
					}
				}
			}
		}
		System.out.println((k+a*a)%1000000007);
	}

}
