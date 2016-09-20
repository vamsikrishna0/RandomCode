package hr.Implementation;

import java.util.Scanner;

public class SaveThePrisoner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();
			int x = ((((((m-1)%n)+1)+s-1)-1)%n)+1;
			
			System.out.println(x);
		}
		
		in.close();
	}
}
