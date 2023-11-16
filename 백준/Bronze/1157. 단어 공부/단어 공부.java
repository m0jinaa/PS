import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input;

		int[] cnt = new int[26];

		input = br.readLine().toCharArray();

		char[] characters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		for (char c : input) {
			if (c >= 97) {
				cnt[c - 97]++;
			} else {
				cnt[c - 65]++;
			}
		}

		int max = -1;
		int answer = -1;
		boolean duplicated = false;

		for (int i = 0; i < 26; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				answer = i;
				duplicated = false;
			} else if (cnt[i] == max)
				duplicated = true;
		}

		if (duplicated) {
			System.out.println("?");
		} else {
			System.out.println(characters[answer]);
		}

	}
}
