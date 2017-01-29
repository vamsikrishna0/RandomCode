package hr.contests.hr;

import java.util.Scanner;

public class RTOfAlgo {

	 public static void insertIntoSorted(int[] ar) {
	        // Fill up this function  
	    	int len = ar.length;
	    	int count = 0;
	    	for (int i= 1; i < len ; i++){
	    		int x = ar[i];
	    		int p = i-1;
	    		while(p >= 0 && x < ar[p]){
	    			ar[p+1] = ar[p];
	    			count++;
	    			p--;
	    			
	    		}
	    		ar[p+1] = x;
	    		printArray(ar);
	    	}
	    	
	    }
	    
	    
	    
	/* Tail starts here */
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	        for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	        }
	        insertIntoSorted(ar);
	        in.close();
	    }
	    
	    
	    private static void printArray(int[] ar) {
	        for(int n: ar){
	            System.out.print(n+" ");
	        }
	        System.out.println("");
	    }


}
