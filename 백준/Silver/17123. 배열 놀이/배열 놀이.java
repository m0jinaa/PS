import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int n, m, x;
		int r1, r2, c1, c2, v;

		int[] row, column;
		int[] rowAdd, columnAdd;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			row = new int[n + 1];
			column = new int[n + 1];
			rowAdd = new int[n + 2];
			columnAdd = new int[n + 2];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 1; j <= n; j++) {
					x = Integer.parseInt(st.nextToken());

					row[i] += x;
					column[j] += x;
				}
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				r1 = Integer.parseInt(st.nextToken());
				c1 = Integer.parseInt(st.nextToken());
				r2 = Integer.parseInt(st.nextToken());
				c2 = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());

				rowAdd[r1] += (v * (c2 - c1 + 1));
				rowAdd[r2 + 1] -= (v * (c2 - c1 + 1));
				columnAdd[c1] += (v * (r2 - r1 + 1));
				columnAdd[c2 + 1] -= (v * (r2 - r1 + 1));
			}

			for (int i = 1; i <= n; i++) {
				rowAdd[i] += rowAdd[i - 1];
				sb.append(row[i] + rowAdd[i]).append(i == n ? "\n" : " ");
			}

			for (int i = 1; i <= n; i++) {
				columnAdd[i] += columnAdd[i - 1];
				sb.append(column[i] + columnAdd[i]).append(i == n ? "\n" : " ");
			}
		}

		System.out.print(sb.toString());
	}
}