import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int INF = 51;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// dp[a][b] -> 할당량 a,b를 채우는데 필요한 최소 고객 수
		int[][] dp = new int[x + 1][y + 1];

		for (int i = 0; i <= x; i++) {
			Arrays.fill(dp[i], INF);
		}

		// 할당량을 채우는데 걸리는 최소 고객 수
		int min = INF;
		// 그 때의 마지막 고객 번호
		int lastCustomer = INF;

		int a, b, na, nb;

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			for (int j = x; j >= 0; j--) {
				for (int k = y; k >= 0; k--) {
					if (dp[j][k] == INF)
						continue;
                    
					na = Math.min(x, j + a);
					nb = Math.min(y, k + b);

					dp[na][nb] = Math.min(dp[na][nb], dp[j][k] + 1);

					if (na == x && nb == y && dp[x][y] < min) {
						min = dp[x][y];
						lastCustomer = i;
					}
				}
			}
		}

		if (min == INF) {
			sb.append(-1).append("\n");
		} else {
			sb.append(min).append("\n").append(lastCustomer).append("\n");
		}

		System.out.print(sb.toString());
	}
}