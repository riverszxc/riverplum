/**
 * 
 */
package me.riverz.tank.v2;

/**
 * @ClassName: ThreadDemo2 
 * @author rivers
 * @date 2017年11月21日 下午1:06:32
 * @Description:
 */
public class ThreadDemo2 {

	/**@date 2017年11月21日 下午1:06:32
	 * @Description: */
	public static void main(String[] args) {
		MyThread2 m1 = new MyThread2("m1",10);
		new Thread(m1).start();
		new Thread(m1).start();
		new Thread(m1).start();
	}

}

class MyThread2 implements Runnable{
	int num;
	String name;
	public MyThread2(String name,int num){
		this.name = name;
		this.num = num;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			
			soldticket();
		}
		
	}
	public  void soldticket(){
		if(this.num>0)
			System.out.println(name+",sold tickets:" + num--);
	}
	
}


/*
public class ThreadRunnableTest extends Thread {         
	private int ticket = 5;         
	public static void main(String[] args) {         
		ThreadRunnableTest th = new ThreadRunnableTest();         
		//         ThreadRunnableTest t1 = new ThreadRunnableTest(); 
		//         ThreadRunnableTest t2 = new ThreadRunnableTest(); 
		//         ThreadRunnableTest t3 = new ThreadRunnableTest();                 
		Thread t1 = new Thread(th, "t1");         
		Thread t2 = new Thread(th, "t2");         
		Thread t3 = new Thread(th, "t3");                 
		t1.start();         
		t2.start();         
		t3.start();     
	}         
	public void run() {         
		for(int i=0;i<20;i++){               
			if(this.ticket>0){               
				System.out.println(this.currentThread().getName() + " 卖票：ticket="+this.ticket--);               
			}         
		}     
	}     
}
*/