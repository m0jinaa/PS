import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 1_000_000_007;
	static int[][] combi;

	static int init(int n) {
		combi = new int[2 * n + 1][2 * n + 1];
		combi[0][0] = 1;
		for (int i = 0; i < 2 * n; i++) {
			for (int j = 0; j <= i; j++) {
				combi[i + 1][j] = (combi[i + 1][j] + combi[i][j]) % MOD;
				combi[i + 1][j + 1] = (combi[i + 1][j + 1] + combi[i][j]) % MOD;
			}
		}
		return combi[2 * n][n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			br.readLine();
		}

		sb.append(init(n)).append(" ").append(n * n).append("\n");

		System.out.print(sb.toString());
	}
}