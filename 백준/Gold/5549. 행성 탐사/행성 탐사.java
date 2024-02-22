import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		int[][] jungle = new int[n + 1][m + 1];
		int[][] ocean = new int[n + 1][m + 1];
		int[][] ice = new int[n + 1][m + 1];

		char[] row;

		for (int i = 1; i <= n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 1; j <= m; j++) {
				jungle[i][j] = jungle[i - 1][j] + jungle[i][j - 1] - jungle[i - 1][j - 1];
				ocean[i][j] = ocean[i - 1][j] + ocean[i][j - 1] - ocean[i - 1][j - 1];
				ice[i][j] = ice[i - 1][j] + ice[i][j - 1] - ice[i - 1][j - 1];

				if (row[j - 1] == 'J') {
					jungle[i][j] += 1;
				} else if (row[j - 1] == 'O') {
					ocean[i][j] += 1;
				} else {
					ice[i][j] += 1;
				}
			}
		}

		int a, b, c, d;
		int v;
		int J, O, I;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			J = jungle[c][d] - jungle[a - 1][d] - jungle[c][b - 1] + jungle[a - 1][b - 1];
			O = ocean[c][d] - ocean[a - 1][d] - ocean[c][b - 1] + ocean[a - 1][b - 1];
			I = ice[c][d] - ice[a - 1][d] - ice[c][b - 1] + ice[a - 1][b - 1];

			sb.append(J).append(" ").append(O).append(" ").append(I).append("\n");
		}

		System.out.print(sb.toString());
	}
}