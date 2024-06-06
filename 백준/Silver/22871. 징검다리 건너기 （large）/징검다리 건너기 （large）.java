import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] A;
	static boolean[] dp;
	static LinkedList<Integer> q;

	public static boolean check(long k) {

		q.clear();
		q.add(1);
		dp[1] = true;

		int x;
		long v;

		while (!q.isEmpty() && !dp[n]) {
			x = q.poll();

			for (int i = x + 1; i <= n; i++) {
				if (dp[i])
					continue;
				else {
					v = (i - x) * (1 + Math.abs(A[i] - A[x]));
					if (v <= k) {
						dp[i] = true;
						q.add(i);
					}
				}
			}

		}

		return dp[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		A = new long[n + 1];
		dp = new boolean[n + 1];
		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long s = 1;
		long e = 5_000_000_000L;

		long answer = e;

		long k;

		while (s <= e) {
			Arrays.fill(dp, false);
			dp[0] = true;

			k = (s + e) / 2;

			if (check(k)) {
				answer = Math.min(answer, k);
				e = k - 1;
			} else {
				s = k + 1;
			}
		}

		System.out.println(answer);

	}
}