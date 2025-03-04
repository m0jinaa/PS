import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] t, b, c;

	static int getInd(int x) {
		int s = 1;
		int e = n;

		int answer = 0;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (t[m] < x) {
				answer = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		t = new int[n + 1];
		b = new int[n + 1];
		c = new int[n + 1];

		long[][] dp = new long[n + 1][2];

		// a 입력
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		// b 입력
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		// c 입력
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		dp[1][1] = c[1];
		int ind;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			ind = getInd(t[i] - b[i]);
			dp[i][1] = Math.max(dp[ind][0], dp[ind][1]) + c[i];
		}

		long answer = Math.max(dp[n][0], dp[n][1]);

		System.out.println(answer);
	}
}