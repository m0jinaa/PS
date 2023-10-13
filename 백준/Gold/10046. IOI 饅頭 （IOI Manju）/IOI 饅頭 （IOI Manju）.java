import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] psum;
	static int n, m, total;
	static Box[] boxes;
	static int[] dp;
	static final int INF = 1_000_000_007;

	static class Box {
		int c, e;

		public Box(int c, int e) {
			super();
			this.c = c;
			this.e = e;
		}

	}

	static int getMax() {
		dp[0] = 0;

		for (Box b : boxes) {
			for (int i = m; i >= 0; i--) {
				if (dp[i] > dp[Math.max(i - b.c, 0)] + b.e) {
					dp[i] = dp[Math.max(i - b.c, 0)] + b.e;
				}
			}
		}

		int answer = 0;

		for (int i = 0; i <= m; ++i) {
			if (answer < psum[i] - dp[i]) {
				answer = psum[i] - dp[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(st.nextToken());

		int[] price = new int[m + 1];

		for (int i = 1; i <= m; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(price);

		psum = new int[m + 1];

		for (int i = 1; i <= m; i++) {
			psum[i] = psum[i - 1] + price[m + 1 - i];
		}

		boxes = new Box[n];

		int c, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			boxes[i] = new Box(c, e);
		}

		dp = new int[m + 1];

		Arrays.fill(dp, INF);

		System.out.println(getMax());
	}
}