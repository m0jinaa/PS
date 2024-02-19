import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final long INF = 1_000_000_000_000_001L;
	static int n, d;
	static long[] dp;
	static int[] next;
	static long[] dist;
	static int[] time;
	static int[] cnt;

	static long getMin(int x) {
		if (dp[x] != INF)
			return dp[x];
		long min = INF;

		int l = 0;
		long temp;

		for (int i = x + 1; i <= n + 1; i++) {
			l += dist[i];
			if (l > d)
				break;
			temp = time[i] + getMin(i);
			if (temp < min) {
				min = temp;
				next[x] = i;
				cnt[x] = cnt[i] + 1;
			}
		}

		return dp[x] = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		d = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());

		dist = new long[n + 2];
		dp = new long[n + 2];
		next = new int[n + 1];
		cnt = new int[n + 2];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i <= n; i++) {
			cnt[i] = 111;
			dp[i] = INF;
		}

		for (int i = 1; i <= n + 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		time = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		cnt[n + 1] = 0;
		dp[n + 1] = 0;

		getMin(0);

		sb.append(dp[0]).append("\n");
		sb.append(cnt[0] - 1).append("\n");
		int repair = 0;

		while ((repair = next[repair]) != n + 1) {
			sb.append(repair).append(" ");
		}

		System.out.println(sb.toString());
	}
}