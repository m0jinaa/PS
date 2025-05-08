import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		// 학교 수
		int b = 5;

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 학교수 * 노선수 = 최대 노선 수
		int max = b * m;

		int[][] dp = new int[max + 1][max + 1];

		int[][] bus = new int[n + 1][b];

		// 초기화
		for (int i = 1; i <= max; i++) {
			Arrays.fill(dp[i], INF);
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 한 학교가 가질 수 있는 노선의 수를 활용해서 학교별 각 노선마다 다른 노선번호 부여
			for (int j = 0; j < b; j++) {
				bus[i][j] = j * m + Integer.parseInt(st.nextToken());
			}

			// 노선과 노선과의 관계를 정리
			for (int j = 0; j < b; j++) {
				for (int k = 0; k < b; k++) {
					dp[bus[i][j]][bus[i][k]] = (j == k ? 1 : 2);
					dp[bus[i][k]][bus[i][j]] = (j == k ? 1 : 2);
				}
			}
		}

		for (int k = 1; k <= max; k++) {
			for (int i = 1; i <= max; i++) {
				if (k == i || dp[i][k] == INF)
					continue;
				for (int j = 1; j <= max; j++) {
					if (k == j || i == j || dp[k][j] == INF)
						continue;
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] - 1);
				}
			}
		}

		int q = Integer.parseInt(br.readLine());

		int u, v, ans;

		int x, y;

		while (q-- > 0) {
			ans = INF;

			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			// 출발 정류장이 속한 노선과 도착 정류장이 속한 노선끼리 전부 비교해서 최솟값 찾기
			for (int i = 0; i < b; i++) {
				x = bus[u][i];

				for (int j = 0; j < b; j++) {
					y = bus[v][j];

					ans = Math.min(ans, dp[x][y]);
				}
			}

			sb.append(ans == INF ? -1 : ans).append("\n");
		}

		System.out.print(sb.toString());
	}
}