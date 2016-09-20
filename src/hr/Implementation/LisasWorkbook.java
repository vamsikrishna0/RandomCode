package hr.Implementation;

import java.util.Scanner;

public class LisasWorkbook {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int numOfProbs[] = new int[n];
		for(int i=0; i< n; i++){
			numOfProbs[i] = in.nextInt();
		}
		int pageNum = 1;
		int count = 0;
		for(int i=0; i< n; i++){
			int p=0;
			int num = numOfProbs[i];
			while(numOfProbs[i] > k){
				if(pageNum > p*k && pageNum <= (p+1)*k)
					count++;
				p++;
				pageNum++;
				numOfProbs[i] -= k;
			}
			if(numOfProbs[i] > 0){
				if(pageNum > p*k && pageNum <= num)
					count++;
				pageNum++;
			}
		}
		System.out.println(count);
		in.close();
	}
}
