package ch06;

import java.util.Scanner;

public class FactorialTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int result = factorial(a);
		System.out.println(result);
	}
	
	static int factorial(int n) {
		int result = 0;
		if(n==1) {
			result = 1;
		} else {
			result = n * factorial(n-1);
		} return result;
	}
	int go(int a) {
		return a;
	}
	void go1() {
		}
}

