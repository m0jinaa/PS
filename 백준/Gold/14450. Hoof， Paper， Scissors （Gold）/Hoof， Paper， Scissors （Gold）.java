import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][][] dp = new int[n + 1][3][k + 1];

		// 0: hoof, 1: paper, 2: scissors

		String gesture;

		HashMap<String, Integer> map = new HashMap<>();

		map.put("H", 0);
		map.put("P", 1);
		map.put("S", 2);

		dp[1][map.get(br.readLine())][0] = 1;

		int ind;

		for (int i = 2; i <= n; i++) {
			gesture = br.readLine();
			ind = map.get(gesture);

			for (int j = 0; j < 3; j++) {
				for (int l = 0; l <= k; l++) {
					if (ind == j) {
						dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 1][j][l] + 1);
					} else {
						dp[i][j][l] = Math.max(dp[i][j][l], dp[i - 1][j][l]);

						if (l < k)
							dp[i][ind][l + 1] = Math.max(dp[i][ind][l + 1], dp[i - 1][j][l] + 1);
					}
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= k; j++) {
				answer = Math.max(answer, dp[n][i][j]);
			}
		}

		System.out.println(answer);
	}
}