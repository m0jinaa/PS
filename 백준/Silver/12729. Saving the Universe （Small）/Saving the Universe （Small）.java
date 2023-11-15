import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static int n, q;
	static HashMap<String, Integer> searchEngine;
	static int[] word;
	static int[][] dp;

	static int getCnt(int e, int x) {
		if (dp[e][x] != -1)
			return dp[e][x];
		else if (x == q - 1)
			return dp[e][x] = 0;

		int cnt = q + 1;

		if (e == word[x + 1]) {
			for (int i = 1; i <= n; i++) {
				if (e == i)
					continue;
				cnt = Math.min(cnt, getCnt(i, x + 1) + 1);
			}
		} else {
			cnt = Math.min(cnt, getCnt(e, x + 1));
		}

		return dp[e][x] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int answer;
		searchEngine = new HashMap<>();

		for (int t = 1; t <= tc; t++) {
			searchEngine.clear();

			n = Integer.parseInt(br.readLine());

			for (int i = 1; i <= n; i++) {
				searchEngine.put(br.readLine(), i);
			}

			q = Integer.parseInt(br.readLine());

			answer = q;

			if (q != 0) {
				word = new int[q];
				for (int i = 0; i < q; i++) {
					word[i] = searchEngine.get(br.readLine());
				}

				dp = new int[n + 1][q];
				for (int i = 1; i <= n; i++) {
					Arrays.fill(dp[i], -1);
				}

				for (int i = 1; i <= n; i++) {
					if (i == word[0])
						continue;
					answer = Math.min(answer, getCnt(i, 0));
				}
			}

			sb.append("Case #").append(t).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}