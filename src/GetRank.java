import java.util.Map;
import java.util.TreeMap;

public class GetRank {
	static int[] get_ranks(String[] words) {
		int n = words.length;
		String s;
		int count = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			s = words[i];
			char[] letters = s.toCharArray();
			TreeMap<Character, Integer> freq = new TreeMap<>();
			for (int j = letters.length - 1; j > -1; j--) {
				char x = letters[j];

				int val = freq.getOrDefault(x, 0);
				freq.put(x, val + 1);

			}

			for (Map.Entry<Character, Integer> e : freq.entrySet()) {

			}

		}
		return null;
	}

	static int get_rank(Map<Character, Integer> freq, String s, int i) {
		if (i == s.length() - 1)
			return 0;
		for (char x : freq.keySet()) {
			if (freq.get(x) == s.charAt(i)) {
				freq.put(x, freq.get(x) - 1);
				get_rank(freq, s, i + 1);
			} else {
				return 0;
			}
		}
		return i;
	}
}
