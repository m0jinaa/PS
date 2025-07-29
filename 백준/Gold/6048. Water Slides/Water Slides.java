import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static long[][] dp;
	static LinkedList<Slide>[] canTake;

	static class Slide {
		int x;
		long f;

		public Slide(int x, long f) {
			super();
			this.x = x;
			this.f = f;
		}
	}

	static long getMax(int x, int t) {
		if (dp[x][t] != -1)
			return dp[x][t];
		else if (x == n)
			return dp[x][t] = 0;

		long min = Long.MAX_VALUE;
		long max = 0L;

		for (Slide s : canTake[x]) {
			max = Math.max(max, getMax(s.x, t) + s.f);

			if (t > 0) {
				min = Math.min(min, getMax(s.x, t - 1) + s.f);
			}
		}
        
		return dp[x][t] = Math.min(min, max);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][k + 1];
		canTake = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			canTake[i] = new LinkedList<>();
			Arrays.fill(dp[i], -1);
		}

		int s, e;
		long f;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			f = Long.parseLong(st.nextToken());

			canTake[s].add(new Slide(e, f));
		}

		long answer = getMax(1, k);

		System.out.println(answer);
	}
}