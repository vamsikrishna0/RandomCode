package hr.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class DynanicArray {
	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int q = in.nextInt();
    	int lastAns = 0;
    	ArrayList<ArrayList<Integer>> seqList = new ArrayList<>(n);
    	

        for(int arr_i=0; arr_i < n; arr_i++){
        	seqList.add(new ArrayList<Integer>());
        }
        for(int arr_i=0; arr_i < q; arr_i++){
            int queryNo = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if(queryNo == 1){
            	int index = ((x ^ lastAns) % n);
            	seqList.get(index).add(y);
            }else if(queryNo == 2){
            	int index = ((x ^ lastAns) % n);
            	int size = seqList.get(index).size();
            	lastAns = seqList.get(index).get(y % size);
            	System.out.println(lastAns);
            }
        }
	}
}
