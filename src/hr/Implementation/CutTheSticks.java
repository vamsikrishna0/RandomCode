package hr.Implementation;

import java.util.Scanner;

public class CutTheSticks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int count = arr.length;
        while(count > 0){
        	System.out.println(count);
            int min = 2000;
            for(int arr_i=0; arr_i < n; arr_i++){
                if(arr[arr_i] < min && arr[arr_i] >0)
                	min = arr[arr_i];
            }
            for(int arr_i=0; arr_i < n; arr_i++){
            	arr[arr_i] = arr[arr_i] - min;
            }
            count = 0;
            for(int arr_i=0; arr_i < n; arr_i++){
            	if(arr[arr_i] > 0)
            		count++;
            }
        }
	}
}
