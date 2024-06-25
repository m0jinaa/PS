import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Cloth {
		int a, b, c;

		public Cloth(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] t = new int[d + 1];

		int[][] dp = new int[d + 1][n];

		for (int i = 1; i <= d; i++) {
			t[i] = Integer.parseInt(br.readLine());
			Arrays.fill(dp[i], -1);
		}

		Cloth[] clothes = new Cloth[n];

		int a, b, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			clothes[i] = new Cloth(a, b, c);

			if (a <= t[1] && t[1] <= b)
				dp[1][i] = 0;
		}

		for (int i = 2; i <= d; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i] < clothes[j].a || clothes[j].b < t[i])
					continue;

				for (int k = 0; k < n; k++) {
					if (dp[i - 1][k] == -1)
						continue;
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(clothes[k].c - clothes[j].c));
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[d][i]);
		}

		System.out.println(answer);
	}
}