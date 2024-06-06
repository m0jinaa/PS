import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] A = new int[n];
		boolean[] dp = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		dp[0] = true;

		int s;
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());

			s = Math.max(0, i - k);

			for (int j = s; j < i; j++) {
				if (!dp[j])
					continue;
				if ((i - j) * (Math.abs(A[i] - A[j]) + 1) <= k) {
					dp[i] = true;
					break;
				}
			}
		}

		System.out.println(dp[n - 1] ? "YES" : "NO");
	}
}