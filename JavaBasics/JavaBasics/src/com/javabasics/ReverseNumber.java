package com.javabasics;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner Sc = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int n = Sc. nextInt();
		int rev = 0, r;
		
		while( n>0) {
			 r = n%10;
			 rev = rev*10+r;
			 n=n/10;
		}
		System.out.println("The reversed number is: "+ rev);
		
	}
}
