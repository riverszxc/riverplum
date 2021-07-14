package me.riverz.recursion;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			System.out.println(palindrome(s.nextLine(),1));
		}
		
	}
	
	public static boolean palindrome(String s, int k){
		if(k*2>=s.length())
			return true;
		else{
			return s.charAt(k)==s.charAt(s.length()-k-1)?palindrome(s,++k):false;
		}
	}

}
