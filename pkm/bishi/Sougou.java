/**
 * 
 */
package me.riverz.bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: Sougou 
 * @author rivers
 * @date 2017年9月28日 下午7:54:32
 * @Description:
 */
public class Sougou {

	/**@date 2017年9月28日 下午7:54:32
	 * @Description: */
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.valueOf(bf.readLine());
			double[] a = new double[n];
			for(int i=0;i<n;i++){
				a[i] = Double.valueOf(bf.readLine());
			}
			if(n<3){
				System.out.println(0);
				return;
			}
			long res=0;
			for(int i=0;i<n;i++){
				
				for(int j=i+2;;j++){
					j = j % n;
					if(a[j]>a[i]){
						if(a[j]-a[i]<180.0){
							res = res + ((j-i-1)>0?(j-i-1):0);
						}else{
							break;
						}
					}else{
						if(a[j]+360.0-a[i]<180.0){
							int x = j+n-i-1;
							res = res + (x>0?x:0);
						}else{
							break;
						}
					}
				}
			}
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
