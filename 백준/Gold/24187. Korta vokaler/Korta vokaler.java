import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static int n;
	static char[] word;
	static long[][] dp;
	static HashSet<Character> vowel;

	static long getCnt(int ind, int c) {
		if (dp[ind][c] != -1)
			return dp[ind][c];

		long cnt = 1;

		if (c == 2) {
			for (int i = ind + 1; i < n; i++) {
				if (!vowel.contains(word[i]))
					continue;
				cnt += getCnt(i, 1);
			}
		} else if (c == 1) {
			for (int i = ind + 1; i < n; i++) {
				if (vowel.contains(word[i])) {
					cnt += getCnt(i, 1);
				} else {
					cnt += getCnt(i, 2);
				}
			}
		} else {
			for (int i = ind + 1; i < n; i++) {
				if (vowel.contains(word[i])) {
					cnt += getCnt(i, 1);
				} else {
					cnt += getCnt(i, 0);
				}
			}
		}

		return dp[ind][c] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = (" " + br.readLine()).toCharArray();

		vowel = new HashSet<>();

		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		vowel.add('y');

		n = word.length;

		dp = new long[n][3];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		long answer = getCnt(0, 0) - 1;

		System.out.println(answer);

	}
}