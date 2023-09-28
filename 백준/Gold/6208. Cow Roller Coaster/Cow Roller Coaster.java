import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, n, b;
	static Line[] lines;
	static int[][] dp;

	static class Line implements Comparable<Line> {
		int x, w, f, c;

		public Line(int x, int w, int f, int c) {
			super();
			this.x = x;
			this.w = w;
			this.f = f;
			this.c = c;
		}

		@Override
		public int compareTo(Line line) {
			return this.x - line.x;
		}
	}

	static int getMax() {
		int ind = 0;
		int nx, nb, nf;
		for (int i = 0; i <= l; i++) {
			while (ind < n && lines[ind].x == i) {
				nx = i + lines[ind].w;
				for (int j = 0; j <= b; j++) {
					nb = j + lines[ind].c;
					if (dp[i][j] == -1 || nb > b)
						continue;

					nf = dp[i][j] + lines[ind].f;

					dp[nx][nb] = Math.max(dp[nx][nb], nf);
				}
				ind++;
			}
		}

		int answer = -1;

		for (int i = 0; i <= b; i++) {
			answer = Math.max(answer, dp[l][i]);
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		l = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		lines = new Line[n];

		int x, w, f, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			lines[i] = new Line(x, w, f, c);
		}

		Arrays.sort(lines);

		dp = new int[l + 1][b + 1];

		for (int i = 0; i <= l; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[0][0] = 0;

		int answer = getMax();

		System.out.println(answer);

	}
}