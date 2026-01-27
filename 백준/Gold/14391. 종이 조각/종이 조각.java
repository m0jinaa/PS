import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;

	static int getMax(int used, int t) {
		if (t == n * m)
			return 0;
		else if ((used & (1 << t)) != 0)
			return getMax(used, t + 1);
		else {
			int v = 0;
			int x = t / m;
			int y = t % m;

			int nu = used;
			int max = 0;

			for (int ny = y; ny < m; ny++) {
				if ((nu & (1 << (x * m + ny))) != 0)
					break;

				nu |= (1 << (x * m + ny));
				v = v * 10 + board[x][ny];
				max = Math.max(max, getMax(nu, t + 1) + v);
			}

			nu = used;
			v = 0;
			for (int nx = x; nx < n; nx++) {
				if ((nu & (1 << (nx * m + y))) != 0)
					break;

				nu |= (1 << (nx * m + y));
				v = v * 10 + board[nx][y];
				max = Math.max(max, getMax(nu, t + 1) + v);
			}

			return max;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				board[i][j] = row[j] - '0';
			}
		}

		System.out.println(getMax(0, 0));
	}
}