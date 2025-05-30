import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][][] dp = new int[n + 2][k + 1][k + 1];

		int[] guests = new int[n + 2];

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			guests[a]++;
			guests[b]--;
		}

		// 파티에 참가한 사람 수
		int g = 0;

		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		dp[1][k][0] = 0;

		int need;

		for (int i = 1; i <= n; i++) {
			g += guests[i];
			for (int j = 0; j <= k; j++) {
				for (int h = 0; h <= k; h++) {
					if (dp[i][j][h] == -1)
						continue;
					else if (g >= t) {
						// 욱제 친구들만으로도 t를 넘길 때
						dp[i + 1][j][0] = Math.max(dp[i + 1][j][0], dp[i][j][h] + 1);
					} else if (g + h >= t) {
						// 욱제친구들 + 투입되어있는 영선이 친구들 >= t
						dp[i + 1][j][h] = Math.max(dp[i + 1][j][h], dp[i][j][h] + 1);
					} else {
						// 영선이 친구를 더 투입 x
						dp[i + 1][j][h] = Math.max(dp[i + 1][j][h], dp[i][j][h]);

						// 투입해서 t를 넘길 수 있으면 투입
						// 필요한 친구 수 <= 투입할 수 있는 영선이 친구 수
						need = t - (g + h);

						if (need > j)
							continue;

						dp[i + 1][j - need][h + need] = Math.max(dp[i + 1][j - need][h + need], dp[i][j][h] + 1);
					}
				}
			}
		}

		int answer = -1;

		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= k; j++) {
				answer = Math.max(answer, dp[n + 1][i][j]);
			}
		}

		System.out.println(answer);
	}
}