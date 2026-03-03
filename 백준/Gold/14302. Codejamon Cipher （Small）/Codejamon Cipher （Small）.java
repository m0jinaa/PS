import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Word {
		int x;
		int[] cnt;

		public Word(int x) {
			super();
			this.x = x;
			this.cnt = new int[26];
		}

		public void add(int x) {
			cnt[x]++;
		}
	}

	public static void main(String[] args) throws Exception {

		final int MOD = 1_000_000_007;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int v, s;
		Word[] words;
		char[] w;
		char[] line;
		int[] dp;
		int[][] alp;

		int n;
		boolean possible;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			v = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			words = new Word[v];

			for (int i = 0; i < v; i++) {
				w = br.readLine().toCharArray();

				words[i] = new Word(w.length);

				for (char c : w) {
					words[i].add(c - 'a');
				}
			}

			sb.append("Case #").append(t).append(":");

			while (s-- > 0) {
				line = (" " + br.readLine()).toCharArray();
				n = line.length;
				alp = new int[n][26];

				dp = new int[n];
				dp[0] = 1;

				for (int i = 1; i < n; i++) {
					for (int j = 0; j < 26; j++) {
						alp[i][j] = alp[i - 1][j];
					}
					alp[i][line[i] - 'a']++;

					for (Word word : words) {
						if (i < word.x)
							continue;
						possible = true;
						for (int j = 0; j < 26; j++) {
							if (alp[i - word.x][j] + word.cnt[j] != alp[i][j]) {
								possible = false;
								break;
							}
						}
						if (possible) {
							dp[i] = (dp[i] + dp[i - word.x]) % MOD;
						}
					}

				}

				sb.append(" ").append(dp[n - 1]);
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}