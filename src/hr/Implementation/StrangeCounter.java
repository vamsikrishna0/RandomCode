package hr.Implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class StrangeCounter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();	
		BigInteger counter = new BigInteger("3");
		BigInteger start = new BigInteger("3");
		
		while(counter.compareTo(BigInteger.valueOf(t)) < 0){
			start = start.multiply(BigInteger.valueOf(2));
			counter = counter.add(start);
		}
		
		counter = counter.subtract(start).add(BigInteger.valueOf(1));
		counter = (BigInteger.valueOf(t)).subtract(counter);
		start = start.subtract(counter);
		System.out.println(start);
		in.close();
	}
}
