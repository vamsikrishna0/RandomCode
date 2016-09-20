package hr.Implementation;

import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int energy = 100;
		int cloudNum = in.nextInt();
		int k = in.nextInt();
		int cloudArr[] = new int[cloudNum];
		for(int i=0; i< cloudNum; i++){
			cloudArr[i] = in.nextInt();
		}
		int present = 0;
		do{
			if(cloudArr[present] == 0)
				energy--;
			else
				energy -= 3;
			present = (present + k) % cloudNum;
		}while(present != 0);
		System.out.println(energy);
		in.close();
	}
}
