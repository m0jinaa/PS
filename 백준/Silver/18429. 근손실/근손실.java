import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dp;
	static int[] A;

	static int getCnt(int x, int d) {
		if (dp[d] != -1) {
			return dp[d];
		}

		int nx, nd;

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if ((d & (1 << i)) != 0 || x - k + A[i] < 500)
				continue;
			nd = d ^ (1 << i);
			nx = x - k + A[i];

			cnt += getCnt(nx, nd);
		}

		return dp[d] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[1 << n];

		Arrays.fill(dp, -1);

		dp[(1 << n) - 1] = 1;

		int answer = getCnt(500, 0);

		System.out.println(answer);
	}
}