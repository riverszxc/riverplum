/**
 * 
 */
package me.riverz.bishi;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Sheep 
 * @author rivers
 * @date 2017年9月15日 下午11:49:22
 * @Description:
 */
public class Sheep {

	/**@date 2017年9月15日 下午11:49:22
	 * @Description: */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sheep(50));
	}
	public static int sheep(int n){

    List<Integer> list = new ArrayList<>();
    list.add(0);
    for(int i = 1; i<=n; i++){
        int xx=0;
        for(int j = 0; j< list.size();j++){
            list.set(j,list.get(j)+1);

            if(list.get(j) == 2||list.get(j) == 4||list.get(j) == 5){
                xx++;
            }

        }
        for(int j=0;j<xx;j++){
            list.add(0);
        }
    }
    int result = 0;
    for(int i : list){
        if(i<6) result++;
    }
    return result;
	}



}
