package hr.Implementation;

import java.util.Scanner;

public class JumpingOnTheClouds {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		int position = 0;
		int steps = 0;
		while (position < n - 1) {
			if (position < n - 2 && c[position + 2] == 0) {
				position += 2;
			} else if (position < n - 2 && c[position + 2] == 1) {
				position++;
			} else if (position == n - 2)
				position++;
			steps++;
		}
		System.out.println(steps);

	}

}
