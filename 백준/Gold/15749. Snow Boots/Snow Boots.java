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
		int b = Integer.parseInt(st.nextToken());

		int[] snow = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		boolean[][] dp = new boolean[n][b];

		for (int i = 0; i < n; i++) {
			snow[i] = Integer.parseInt(st.nextToken());
		}

		int[][] boot = new int[b][];

		int s, d;

		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			boot[i] = new int[] { s, d };
		}

		Arrays.fill(dp[0], true);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < b; j++) {
				if (!dp[i][j])
					continue;
				for (int k = j; k < b; k++) {
					if (boot[k][0] < snow[i])
						continue;
					for (int l = 1; i + l < n && l <= boot[k][1]; l++) {
						if (snow[i + l] <= boot[k][0])
							dp[i + l][k] = true;
					}
				}
			}
		}

		int answer = -1;

		for (int i = 0; i < b; i++) {
			if (dp[n - 1][i]) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}