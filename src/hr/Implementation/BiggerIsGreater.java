package hr.Implementation;

import java.util.Scanner;

public class BiggerIsGreater {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n > 0) {
			String text = in.next();
			char[] textArray = text.toCharArray();
			int z = textArray.length - 2;
			while (z >= 0 && textArray[z + 1] <= (textArray[z])) {
				z--;
			}
			if(z >=0){
				int x = textArray.length - 1;
				while (x > z && textArray[x] <= textArray[z]) {
					x--;
				}
				char temp = textArray[x];
				textArray[x] = textArray[z];
				textArray[z] = temp;
				int last = textArray.length - 1;
				z++;
				while (last >= z) {
					temp = textArray[last];
					textArray[last] = textArray[z];
					textArray[z] = temp;
					z++;
					last--;
				}
			}
			String finalString = new String(textArray);
			if (z < 0 || finalString.equalsIgnoreCase(text) )
				System.out.println("no answer");
			else
				System.out.println(finalString);
			n--;
		}

		in.close();
	}
}
