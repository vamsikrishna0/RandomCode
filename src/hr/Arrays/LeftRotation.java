package hr.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeftRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int d = in.nextInt();
    	ArrayList<Integer> array = new ArrayList<>();
    	for(int i=0; i<n; i++){
    		array.add(in.nextInt());
    	}
    	//rotate the collection by d distance. -ve will rotate it from left.
    	Collections.rotate(array, -d);
    	
    	for(int i=0; i<n; i++){
    		System.out.print(array.get(i) + " ");
    	}
	}
}
