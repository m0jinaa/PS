import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dp;
	static int[] skill;

	static void getMax() {

		dp[1] = skill[1];

		int max;

		for (int i = 2; i <= n; i++) {
			max = skill[i];
			for (int j = i; j > 0 && i - j + 1 <= k; j--) {
				max = Math.max(max, skill[j]);
				dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		skill = new int[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			skill[i] = Integer.parseInt(br.readLine());
		}

		getMax();

		System.out.println(dp[n]);
	}
}