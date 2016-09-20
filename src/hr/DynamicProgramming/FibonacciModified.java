package hr.DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	static BigInteger[] interVals;
	static BigInteger temp;

	public static void main(String[] args) {
		BigInteger a;
		BigInteger b;
		int n;
		Scanner sc = new Scanner(System.in);
		a = sc.nextBigInteger();
		b = sc.nextBigInteger();
		n = sc.nextInt();
		interVals = new BigInteger[n];
		interVals[0] = a;
		interVals[1] = b;
		System.out.println(findNth(n - 1));

		sc.close();
	}

	private static BigInteger findNth(int n) {
		if (n > 1 && interVals[n] == null) {
			temp = findNth(n - 1).pow(2).add(findNth(n - 2));
			interVals[n] = temp;
			return temp;
		} else {
			return interVals[n];
		}

	}

}
