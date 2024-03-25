import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] cnt;
	static char[] word, w;

	static boolean similar() {
		int[] count = new int[26];

		for (char c : w) {
			count[c - 'A']++;
		}

		boolean answer = true;

		if (Math.abs(w.length - word.length) > 1)
			answer = false;

		int diff = 0;

		for (int i = 0; i < 26; i++) {
			diff += Math.abs(cnt[i] - count[i]);
		}

		if (diff > 2)
			answer = false;

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()) - 1;

		cnt = new int[26];
		word = br.readLine().toCharArray();

		for (char c : word) {
			cnt[c - 'A']++;
		}

		int answer = 0;

		while (n-- > 0) {
			w = br.readLine().toCharArray();

			if (similar()) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}