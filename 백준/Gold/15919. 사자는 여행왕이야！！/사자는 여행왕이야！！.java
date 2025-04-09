import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int n, m;
	static Trip[] trips;
	static int[] dp;

	static class Trip implements Comparable<Trip> {
		int s, e;

		public Trip(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Trip t) {
			if (this.s != t.s) {
				return this.s - t.s;
			} else {
				return this.e - t.e;
			}
		}
	}

	static int getMinInterval(int x) {
		if (dp[x] != -1)
			return dp[x];

		// 현재 여행을 마지막으로 하는 경우 최대값
		int ret = n - trips[x].e;

		int min;
		for (int i = x + 1; i < m; i++) {
			// 일정 겹치는 경우 제외
			if (trips[x].e >= trips[i].s)
				continue;

			min = Math.max(trips[i].s - trips[x].e - 1, getMinInterval(i));

			ret = Math.min(min, ret);
		}

		return dp[x] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		m = Integer.parseInt(br.readLine());

		trips = new Trip[m];

		int s, e;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			trips[i] = new Trip(s, e);
		}

		Arrays.sort(trips);

		dp = new int[m];

		Arrays.fill(dp, -1);

		int answer = INF;

		for (int i = 0; i < m; i++) {
			answer = Math.min(answer, Math.max(trips[i].s - 1, getMinInterval(i)));
		}

		System.out.println(answer);
	}
}