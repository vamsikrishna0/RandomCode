package interview;

import java.util.Scanner;

public class DataHiding {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (true && in.hasNextLine()) {
			String entry = in.nextLine();
			if (entry.equals(""))
				break;
			if (entry.charAt(0) == 'E') {
				entry = entry.replaceAll(" ", "");
				int start = 0, end = entry.length() - 1;
				for (int i = 0; i < entry.length(); i++) {
					if (entry.charAt(i) == ':') {
						start = i + 1;
					} else if (entry.charAt(i) == '@') {
						end = i - 1;
						break;
					}
				}
				StringBuilder str = new StringBuilder(entry.substring(0, start));
				str.append(entry.charAt(start)).append("*****").append(entry.substring(end));
				System.out.println(str);

			} else if (entry.charAt(0) == 'P') {
				String number = entry.substring(entry.length() - 4);

				entry = entry.replaceAll("[\\s()P:-]", "");
				entry = entry.replaceAll("\\d", "*");
				int len = entry.length();
				StringBuilder str = new StringBuilder("P:");
				if (len > 11)
					str.append(entry.substring(0, len - 10)).append("-").append(entry.substring(len - 10, len - 7))
							.append("-").append(entry.substring(len - 7, len - 4)).append("-").append(number);
				else
					str.append(entry.substring(len - 10, len - 7)).append("-").append(entry.substring(len - 7, len - 4))
							.append("-").append(number);
				System.out.println(str);
			}
		}
		in.close();
	}
}
