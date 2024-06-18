import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] combi;

	static void init() {
		final int MAX = 1000;
		final int MOD = 1_000_000_007;

		combi = new int[MAX + 1][MAX + 1];

		combi[0][0] = 1;

		for (int i = 1; i <= MAX; i++) {
			combi[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				combi[i][j] = (combi[i - 1][j - 1] + combi[i - 1][j]) % MOD;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		int t = Integer.parseInt(br.readLine());

		int n, r;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			sb.append(combi[n][r]).append("\n");
		}

		System.out.print(sb.toString());
	}
}