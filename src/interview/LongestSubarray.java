package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestSubarray {

	public static void main(String[] args) throws IOException {
		System.out.println("4");
		System.out.println("0 1 2 3");
		System.out.println("2");
		Scanner in = new Scanner(System.in);
		int res;
		
		int _a_size = 0;
		_a_size = in.nextInt();
		int[] _a = new int[_a_size];
		int _a_item;
		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = in.nextInt();
			_a[_a_i] = _a_item;
		}

		int _k;
		_k = in.nextInt();

		res = maxLength(_a, _k);
		System.out.println(res);
	}

	static int maxLength(int[] a, int k) {
		int len = a.length;
		int size = len;
		int[] cumulativeSum = new int[len];
		int temp = 0;
		for (int i = 0; i < len; i++) {
			temp += a[i];
			cumulativeSum[i] = temp;
		}
		while (size > 0) {
			for (int j = 0; j <= len - size; j++) {
				int tempSum = 0;
				int finalIndex = j+size-1;
				if(j == 0){
					tempSum = cumulativeSum[finalIndex];
				}else{
					tempSum = cumulativeSum[finalIndex] - cumulativeSum[j-1];
				}
				if(tempSum <= k)
					return size;
			}
			size--;
		}
		return 0;
	}
}
