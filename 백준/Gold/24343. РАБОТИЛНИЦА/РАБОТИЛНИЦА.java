import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int t, n;
	static boolean[] dp;
	static int[] tasks;

	static int getMax() {
		dp[0] = true;

		for (int x : tasks) {
			for (int i = t; i >= x; i--) {
				dp[i] = dp[i] || dp[i - x];
			}
		}

		int answer = 0;
		for (int i = t; i >= 0; i--) {
			if (dp[i]) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int total, x;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			dp = new boolean[t + 1];

			tasks = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			total = 0;

			for (int i = 0; i < n; i++) {
				tasks[i] = Integer.parseInt(st.nextToken());
				total += tasks[i];
			}

			x = getMax();
			if (total - x <= t)
				sb.append("1\n");
			else
				sb.append("0\n");
		}

		System.out.print(sb.toString());
	}
}