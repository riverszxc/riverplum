/**
 * 
 */
package me.riverz.tank.v2;

/**
 * @ClassName: ThreadDemo 
 * @author rivers
 * @date 2017年11月21日 下午12:56:14
 * @Description:
 */
public class ThreadDemo {

	/**@date 2017年11月21日 下午12:56:14
	 * @Description: */
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();

	}

}

class MyThread extends Thread{
	private int ticket = 5;
	public void run() {         
		for(int i=0;i<20;i++){  
			if(this.ticket>0){               
				System.out.println(this.currentThread().getName() + " 卖票：ticket="+this.ticket--);               
			}         
		}     
	}   
}