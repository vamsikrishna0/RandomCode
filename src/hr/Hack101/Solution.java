package hr.Hack101;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long h[] = new long[n];
        
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextLong();
        }
        
        int m = in.nextInt();
        int[] lasers = new int[m];
        for(int h_i=0; h_i < m; h_i++){
            lasers[h_i] = in.nextInt();
        }
        Arrays.sort(lasers);
        for(int h_i=0; h_i < m; h_i++){
        	int x;
        	if(h_i >0)
        		x = lasers[h_i-1]-1;
        	else
        		x = 0;
        	for(int i = x; i < lasers[h_i]-1; i++){
        		if(h[i] > lasers[h_i]-1-i){
        			h[i] = lasers[h_i]-1-i;
        		}
        	}
        }
        int sum = 0;
        for(int h_i=0; h_i < n; h_i++){
            sum += h[h_i];
        }
        System.out.println(sum);
    }
}

