import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static HashSet<Integer> set;
	static int[] dp;

	static int getMin() {

		for (int x : set) {
			for (int i = x; i <= n; i++) {
				dp[i] = Math.min(dp[i], dp[i - x] + 1);
			}
		}

		return dp[n];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		final int INF = n + 1;

		st = new StringTokenizer(br.readLine(), " ");

		set = new HashSet<>();

		int[] woks = new int[m];

		for (int i = 0; i < m; i++) {
			woks[i] = Integer.parseInt(st.nextToken());
			set.add(woks[i]);
		}

		int s;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				s = woks[i] + woks[j];
				set.add(s);
			}
		}
		dp = new int[n + 1];

		Arrays.fill(dp, INF);
		dp[0] = 0;

		int answer = getMin();

		System.out.println(answer == INF ? -1 : answer);
	}
}