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

		char[] row;

		int[][] D = new int[n + 1][m + 1];
		int[][] P = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();

			for (int j = 1; j <= m; j++) {
				D[i][j] = row[j - 1] - '0';
			}
		}

		int max;

		int answer = 0;

		for (int j = 1; j <= m; j++) {
			for (int i = 1; i <= n; i++) {
				max = 0;
				for (int k = -1; k < 2 && i + k <= n; k++) {
					max = Math.max(max, P[i + k][j - 1]);
				}
				answer = Math.max(answer, max);
				P[i][j] = max + D[i][j];
			}
		}

		System.out.println(answer);
	}
}