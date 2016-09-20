package hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealerTrackCodingExcercise {

	static String shortenString(String input) {
		String[] letters = input.split("");
		String result = "";
		for (int i = 0; i < letters.length; i++) {
			String string = letters[i];
			if (!string.matches("[a-zA-Z]")) {
				result = result + string;
			} else {
				String tempWord = "";
				while (i < letters.length && letters[i].matches("[a-zA-Z]")) {
					tempWord = tempWord + letters[i];
					i++;
				}
				i--;
				String[] lettersOfTempWord = tempWord.split("");
				result = result + lettersOfTempWord[0];
				ArrayList<String> middleLetters = new ArrayList<String>();
				int count = 0;
				if (lettersOfTempWord.length > 2) {
					for (int p = 1; p < lettersOfTempWord.length - 1; p++) {
						if (!middleLetters.contains(lettersOfTempWord[p])) {
							middleLetters.add(lettersOfTempWord[p]);
							count++;
						}
					}
					result = result + count + lettersOfTempWord[lettersOfTempWord.length - 1];
				} else {
					result = result + 0 + lettersOfTempWord[lettersOfTempWord.length - 1];
				}
			}

		}
		System.out.println(result);
		return result;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		String _input;
		try {
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}

		res = shortenString(_input);
		bw.write(res);
		bw.newLine();

		bw.close();
	}


}
