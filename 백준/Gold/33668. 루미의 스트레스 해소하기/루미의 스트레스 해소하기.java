import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Hobby {
		int l, h, m;

		public Hobby(int l, int h, int m) {
			super();
			this.l = l;
			this.h = h;
			this.m = m;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = -1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		Hobby[] hobbies = new Hobby[n];

		int l, h, m;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			hobbies[i] = new Hobby(l, h, m);
		}

		int[][] dp = new int[b + 1][c + 1];

		for (int i = 0; i <= b; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		int nh, nm, nl;

		for (int i = 0; i < b; i++) {
			for (int j = 0; j <= c; j++) {
				if (dp[i][j] == INF) {
					continue;
				}

				// 취미없이 시간 보내기
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] - f);

				// 취미 즐기기
				for (int k = 0; k < n; k++) {
					// 취미를 즐길 수 있는 시간과 체력이 남아있는지 확인

					nh = i + hobbies[k].h;
					nm = j + hobbies[k].m;

					if (nh > b || nm > c)
						continue;

					nl = dp[i][j] + ((c - j > d) ? hobbies[k].l : (int) Math.floor(((100 - e) / 100.0) * hobbies[k].l));

					dp[nh][nm] = Math.min(a, Math.max(dp[nh][nm], nl));
				}
			}
		}

		int max = INF;

		for (int i = 0; i <= c; i++) {
			max = Math.max(max, dp[b][i]);
		}

		int answer = Math.max(0, a - max);

		System.out.println(answer);
	}
}