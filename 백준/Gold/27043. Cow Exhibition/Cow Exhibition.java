import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;

	static class Cow {
		int s, f;

		public Cow(int s, int f) {
			super();
			this.s = s;
			this.f = f;
		}
	}

	static Cow[] cows;
	static int[] dp;
	static final int INF = -1_000_001;
	static final int MAX = 200000;

	static int getMax() {
		dp[MAX / 2] = 0;

		int nx, ny;

		for (Cow c : cows) {
			if (c.s >= 0) {
				for (int i = MAX - c.s; i >= 0; i--) {
					if (dp[i] == INF)
						continue;

					nx = i + c.s;
					ny = dp[i] + c.f;

					dp[nx] = Math.max(dp[nx], ny);
				}
			} else {
				for (int i = -c.s; i <= MAX; i++) {
					if (dp[i] == INF)
						continue;

					nx = i + c.s;
					ny = dp[i] + c.f;

					dp[nx] = Math.max(dp[nx], ny);
				}
			}
		}

		int answer = 0;
		int temp;

		for (int i = MAX / 2; i <= MAX; i++) {
			if (dp[i] < 0)
				continue;
			temp = i + dp[i] - MAX / 2;
			answer = Math.max(answer, temp);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		cows = new Cow[n];

		int s, f;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());

			cows[i] = new Cow(s, f);
		}

		dp = new int[MAX + 1];

		Arrays.fill(dp, INF);

		int answer = getMax();

		System.out.println(answer);
	}
}