package me.riverz.recursion;

public class Hanoi {
	private int i=1;
	
/* 汉诺塔
 * 递归思想其实很简单，只需想通一轮循环即可，其余递归过程均与第一轮相同
 * 第一步将n-1部分从1经过3移到2，
 * 第二步将最大的从1移到3
 * 第三步将n-1部分从2经过1移到3*/
	public void hanoi(int n, int from, int agent, int to){
		if(n==1)
			move(n,from,to);
		else{
			hanoi(n-1,from,to,agent);
			move(n,from,to);
			hanoi(n-1,agent,from,to);
		}
	}
	
	private void move(int n, int from, int to){
		System.out.println("Step "+i+++": No."+n+" from "+from+" to "+to);
	}

	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.hanoi(4,1,2,3);

	}
}
