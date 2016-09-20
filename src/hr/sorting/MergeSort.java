package hr.sorting;

import java.util.Scanner;

public class MergeSort {
	  
	  public void copy(int[] b,int[] a, int lo,int hi){
	    for(int i = lo; i <= hi; i++)
		a[i]=b[i];
	  }
	  public void merge(int[] a, int[] b,int lo,int hi,int mid){
		    int i = lo;
			int j = mid+1;
			for(int k =lo; k <= hi; k++){
			  if(i <= mid && (j > hi || a[i] <= a[j])){
			    b[k] = a[i];
				i++;
			  }else{
			    b[k] = a[j];
				j++;
			  }
			}
		  }
	  public void split(int[] a, int[] b, int lo, int hi){
		    if ((hi - lo) < 1) return;
			
			int mid = (hi+lo)/2;
			split(a, b, lo, mid);
			split(a, b, mid+1, hi);
			merge(a, b, lo, hi, mid);
			copy(b, a, lo, hi);
			
		  }
	  public int[] sort(int[] a){
		  int n = a.length;
		  int[] b = new int[n];
		  split(a, b, 0,n-1);
		  return a;
	  }
	  public static void main(String args[]){
		    Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i=0; i < n; i++){
			  p[i] = sc.nextInt();
			}
			MergeSort x = new MergeSort();
			int[] r = x.sort(p);
			
			for (int i=0; i<n; i++){
			  System.out.println(r[i]);
			}
		  }
	}
