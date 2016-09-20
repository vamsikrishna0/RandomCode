package hr.Arrays;

import java.util.Scanner;

public class TwoDArrayDS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        //This is the key. When recursively calculating and updating the max value. 
        //The variable has to be initialized to the minimum possible value.
        int maxDistance = -70;
        for(int arr_i=0; arr_i < 4; arr_i++){
            for(int arr_j=0; arr_j < 4; arr_j++){
            	int sum = arr[arr_i][arr_j] + arr[arr_i][arr_j+1] + arr[arr_i][arr_j+2]+
            			arr[arr_i+1][arr_j+1] +
            			arr[arr_i+2][arr_j] + arr[arr_i+2][arr_j+1] + arr[arr_i+2][arr_j+2];
                if(sum > maxDistance){
                	maxDistance = sum;	
                }
            }
        }
        System.out.println(maxDistance);
        in.close();
	}

}
