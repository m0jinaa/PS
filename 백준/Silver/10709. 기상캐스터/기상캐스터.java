import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] answer = new int[n][m];
		char[] row;
		for (int i = 0; i < n; i++) {
			Arrays.fill(answer[i], -1);
			row = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				if (row[j] == 'c') {
					answer[i][j] = 0;
					for (int k = j + 1; k < m; k++) {
						answer[i][k] = answer[i][k - 1] + 1;
					}
				}

				sb.append(answer[i][j]).append(j != m - 1 ? " " : "\n");
			}
		}

		System.out.print(sb.toString());
	}
}