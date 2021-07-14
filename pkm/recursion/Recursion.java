package me.riverz.recursion;

public class Recursion {
	private int value;
	public Recursion() {
		
	}
	public Recursion(int i) {
		this.value = i;
	}
	public static void main(String[] args) {
		// 
		Recursion r = new Recursion();
		Recursion a = new Recursion(1);
		Recursion b = new Recursion(2);
		r.test(a, b);
		System.out.println(a.value+","+b.value);
		r.test1(a, b);
		System.out.println(a.value+","+b.value);
		
		
		
	}
	
	public void test(Recursion a, Recursion b){
		Recursion t=a;
		a=b;
		b=t;
		System.out.println(a.value+","+b.value);
	}
	public void test1(Recursion a, Recursion b){
		int t=a.value;
		a.value=b.value;
		b.value=t;
		System.out.println(a.value+","+b.value);
	}
	
	

}
