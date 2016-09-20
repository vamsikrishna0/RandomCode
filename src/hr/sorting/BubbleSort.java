package hr.sorting;

import java.util.Scanner;

public class BubbleSort{
	  public static void main(String args[]){
		  Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] p = new int[n];
		  for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
		  }
		  BubbleSort x = new BubbleSort();
		  int[] dk = x.sort(p);
		  for (int i = 0; i < n; i++) {
				System.out.println(dk[i]);
			}
	    
	  }
	  
	  public int[] sort(int[] p){
	    int j, tmp;
	    for(int i= p.length-1 ; i > 0; i--){
		  j = 1;
		  while(j <= i){
		    if(p[j] < p[j-1]){
			  tmp = p[j];
			  p[j] = p[j-1];
			  p[j-1] = tmp;
			}
			j++;
		  }
		}
	    return p;
	  }
	}
