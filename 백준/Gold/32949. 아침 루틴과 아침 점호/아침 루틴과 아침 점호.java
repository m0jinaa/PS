import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Routine implements Comparable<Routine> {
		int s, p;
		long h;

		public Routine(int s, int p, long h) {
			super();
			this.s = s;
			this.p = p;
			this.h = h;
		}

		@Override
		public int compareTo(Routine r) {
			return this.s - r.s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		long answer = 0;

		Routine[] routines = new Routine[n];

		int s, p;
		long h;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			h = Long.parseLong(st.nextToken());

			routines[i] = new Routine(s, p, h);
		}

		Arrays.sort(routines);

		long[][] dp = new long[n + 1][t + 1];

		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[0][0] = 0;

		int limitI;

		for (Routine r : routines) {
			if (r.s > 0)
				dp[0][0] = -1;
			limitI = Math.max(0, r.s - 1);
			for (int i = r.s; i >= limitI; i--) {
				for (int j = t; j >= 0; j--) {
					if (dp[i][j] == -1)
						continue;
					else if (j + r.p > t)
						continue;

					dp[r.s][j + r.p] = Math.max(dp[r.s][j + r.p], dp[i][j] + r.h);

					answer = Math.max(answer, dp[r.s][j + r.p]);
				}
			}
		}

		System.out.println(answer);
	}
}