package interview;
import java.util.Arrays;
import java.util.HashSet;

public class GeneticMutation {
	static int findMutationDistance(String start, String end, String[] bank) {

		HashSet<String> stringBank = new HashSet<>(Arrays.asList(bank));
		char[] temp = start.toCharArray();
		boolean status = false;
		int count = 0;
		for (int i = 0; i < 8; i++) {
			if (start.charAt(i) != end.charAt(i)) {
				temp[i] = end.charAt(i);
				if (!stringBank.contains(new String(temp))) {
					status = true;
					break;
				} else {
					count++;

				}
			}
		}

		if (status) {
			count = 0;
			temp = start.toCharArray();
			status = false;
			for (int i = 7; i >= 0; i--) {
				if (start.charAt(i) != end.charAt(i)) {
					temp[i] = end.charAt(i);
					if (!stringBank.contains(new String(temp))) {
						status = true;
						break;
					} else {
						count++;

					}
				}
			}
		}
		if (status)
			return -1;
		else
			return count;
	}
}