import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static char[] dna;
	static int[][] dp;

	static int getMax(int s, int e) {
		if (s >= e)
			return 0;
		if (s >= n)
			return 0;
		if (dp[s][e] != -1)
			return dp[s][e];

		int len = 0;

		if (dna[s] == 'a') {
			for (int i = s + 1; i <= e; i++) {
				if (dna[i] == 't') {
					len = Math.max(len, 2 + getMax(s + 1, i - 1) + getMax(i + 1, e));
				}
			}
		} else if (dna[s] == 'g') {
			for (int i = s + 1; i <= e; i++) {
				if (dna[i] == 'c') {
					len = Math.max(len, 2 + getMax(s + 1, i - 1) + getMax(i + 1, e));
				}
			}
		}

		len = Math.max(len, getMax(s + 1, e));

		return dp[s][e] = len;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dna = br.readLine().toCharArray();
		n = dna.length;

		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int answer = getMax(0, n - 1);

		System.out.println(answer);
	}
}
