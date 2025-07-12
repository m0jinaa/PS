import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MAX = 5000;
		final int MAX_N = 10_000_000;
		final int MAX_K = 10;

		long[][] combi = new long[MAX + 1][MAX_K + 1];

		combi[0][0] = 1;

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j <= i && j <= MAX_K; j++) {
				if (combi[i][j] > MAX_N) {
					combi[i][j] = MAX_N;
				}
				combi[i + 1][j] += combi[i][j];
				if (j < MAX_K)
					combi[i + 1][j + 1] += combi[i][j];
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (k == 1) {
			sb.append(1);
			while (--n > 0) {
				sb.append(0);
			}
		} else {
			boolean empty = true;

			int d = MAX;

			while (d != 0 || k != 0) {
				if (d == 5)
					sb.append("");
				if (k == 0 || combi[d - 1][k] >= n) {
					if (!empty) {
						sb.append(0);
					}
					d--;
				} else {
					empty = false;
					sb.append(1);
					d--;
					n -= combi[d][k];
					k--;
				}
			}
		}

		System.out.println(sb.toString());
	}
}