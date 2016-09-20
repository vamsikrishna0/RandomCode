package interview;

import java.util.stream.IntStream;

public class Sol1 {
	public static void main(String[] args) {
		System.out.println(IntStream.iterate(1, f -> f+1)
		         .limit(5000)
		         .sum()*2 );
		System.out.println(5000 * 4999);
	}

}
