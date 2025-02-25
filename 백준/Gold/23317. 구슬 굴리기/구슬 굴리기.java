import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] combi;
	static int n;

	static void init() {
		combi = new long[n + 1][n + 1];

		combi[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				combi[i + 1][j] += combi[i][j];
				combi[i + 1][j + 1] += combi[i][j];
			}
		}
	}

	static class Space implements Comparable<Space> {
		int x, y;

		public Space(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Space s) {
			if (this.x != s.x) {
				return this.x - s.x;
			} else {
				return this.y - s.y;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int m = Integer.parseInt(br.readLine());

		int x, y;

		Space[] spaces = new Space[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			spaces[i] = new Space(x, y);
		}

		Arrays.sort(spaces);

		init();

		long cnt = 1;

		x = 0;
		y = 0;

		int dx, dy;

		for (Space s : spaces) {
			dx = s.x - x;
			dy = s.y - y;

			if (dy < 0) {
				cnt = 0;
				break;
			}

			cnt *= combi[dx][dy];

			x = s.x;
			y = s.y;
		}

		long answer = 0;

		for (int i = 0; i < n; i++) {
			dx = n - 1 - x;
			dy = i - y;

			if (dy < 0)
				continue;

			answer += cnt * combi[dx][dy];
		}

		System.out.println(answer);
	}
}