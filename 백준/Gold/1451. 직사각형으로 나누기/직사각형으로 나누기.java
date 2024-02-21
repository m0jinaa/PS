import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] sum = new int[n + 1][m + 1];

		char[] row;
		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (row[j - 1] - '0');
			}
		}

		long answer = 0;
		long a, b, c, v;

		// 가로로 세개
		for (int i = 1; i <= n - 2; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				a = sum[i][m];
				b = sum[j][m] - sum[i][m];
				c = sum[n][m] - sum[j][m];

				v = a * b * c;
				answer = Math.max(answer, v);
			}
		}

		// 세로로 세개
		for (int i = 1; i <= m - 2; i++) {
			for (int j = i + 1; j <= m - 1; j++) {
				a = sum[n][i];
				b = sum[n][j] - sum[n][i];
				c = sum[n][m] - sum[n][j];

				v = a * b * c;
				answer = Math.max(answer, v);
			}
		}

		// ㅕ,ㅑ
		for (int i = 1; i <= m - 1; i++) {
			for (int j = 1; j <= n - 1; j++) {

				// ㅕ
				a = sum[j][i];
				b = sum[n][i] - sum[j][i];
				c = sum[n][m] - sum[n][i];

				v = a * b * c;
				answer = Math.max(answer, v);

				// ㅑ
				a = sum[n][i];
				b = sum[j][m] - sum[j][i];
				c = sum[n][m] - sum[n][i] - sum[j][m] + sum[j][i];

				v = a * b * c;
				answer = Math.max(answer, v);
			}
		}

		// ㅛ,ㅠ
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 1; j++) {
				// ㅛ
				a = sum[i][j];
				b = sum[i][m] - sum[i][j];
				c = sum[n][m] - sum[i][m];

				v = a * b * c;

				answer = Math.max(answer, v);

				// ㅠ
				a = sum[i][m];
				b = sum[n][j] - sum[i][j];
				c = sum[n][m] - sum[i][m] - sum[n][j] + sum[i][j];

				v = a * b * c;
				answer = Math.max(answer, v);
			}
		}

		System.out.println(answer);
	}
}
