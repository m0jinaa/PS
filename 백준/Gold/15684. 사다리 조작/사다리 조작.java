import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] loc;
	static boolean[][] line;
	static final int INF = 1_000_000_007;

	static void change(int x) {
		int t = loc[x];
		loc[x] = loc[x + 1];
		loc[x + 1] = t;
	}

	static int getMin(int x, int y, int c) {
		if (x == n && y == m) {
			for (int i = 1; i <= m; i++) {
				if (loc[i] != i)
					return INF;
			}

			return c;
		}

		int answer = INF;

		if (line[x][y]) {
			change(y);
			answer = Math.min(answer, getMin(x, y + 1, c));
			change(y);
		} else {
			if (c < 3 && y < m && (y == 1 || (y > 1 && !line[x][y - 1])) && !line[x][y + 1]) {
				change(y);
				line[x][y] = true;
				answer = Math.min(answer, getMin(x, y + 1, c + 1));
				line[x][y] = false;
				change(y);
			}

			if (y == m)
				answer = Math.min(answer, getMin(x + 1, 1, c));
			else
				answer = Math.min(answer, getMin(x, y + 1, c));
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		line = new boolean[n + 1][m + 1];
		loc = new int[m + 1];

		for (int i = 0; i <= m; i++) {
			loc[i] = i;
		}

		int x, y;

		while (h-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			line[x][y] = true;
		}

		int answer = getMin(1, 1, 0);

		System.out.println(answer == INF ? -1 : answer);
	}
}
