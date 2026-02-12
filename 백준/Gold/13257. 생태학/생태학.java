import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 20;
	static int MAX_D = 5;
	static int n, c, d, m;
	static BigDecimal[][] combi;
	static BigDecimal[][] dp;

	static void init() {
		combi = new BigDecimal[MAX_N + 1][MAX_N + 1];

		for (int i = 0; i <= MAX_N; i++) {
			for (int j = 0; j <= MAX_N; j++) {
				combi[i][j] = BigDecimal.ZERO;
			}
		}

		combi[0][0] = BigDecimal.ONE;

		for (int i = 0; i < MAX_N; i++) {
			for (int j = 0; j <= i; j++) {
				combi[i + 1][j] = combi[i + 1][j].add(combi[i][j]);
				combi[i + 1][j + 1] = combi[i + 1][j + 1].add(combi[i][j]);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		init();

		// dp[i][j] => i번째날에 측정기가 부착되지않은 새가 j마리인 경우의 수
		dp = new BigDecimal[MAX_D + 1][n + 1];

		for (int i = 0; i <= MAX_D; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = BigDecimal.ZERO;
			}
		}
		dp[0][0] = BigDecimal.ONE;

		for (int i = 0; i < d; i++) {
			for (int j = 0; j <= n; j++) {
				if (BigDecimal.ZERO.equals(dp[i][j]))
					continue;
				for (int k = 0; k <= c && k <= j; k++) { // 측정기 부착된 새를 k마리 잡는 경우의 수
					if (n - j < c - k)
						continue;
					dp[i + 1][j + c - k] = dp[i + 1][j + c - k]
							.add(dp[i][j].multiply(combi[j][k].multiply(combi[n - j][c - k])));
				}
			}
		}

		System.out.println(dp[d][m].divide(combi[n][c].pow(d), 16, RoundingMode.FLOOR).toPlainString());
	}
}