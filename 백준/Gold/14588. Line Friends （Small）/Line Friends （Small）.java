import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Loc implements Comparable<Loc> {
		int i, s, e;

		public Loc(int i, int x, int y) {
			super();
			this.i = i;
			this.s = x;
			this.e = y;
		}

		@Override
		public int compareTo(Loc loc) {
			if (this.s != loc.s)
				return this.s - loc.s;
			return this.e - loc.e;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int INF = 400;

		Loc[] loc = new Loc[n];

		int s, e;

		int[][] dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			loc[i] = new Loc(i, s, e);
			Arrays.fill(dist[i], INF);
		}

		Arrays.sort(loc);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (loc[i].e >= loc[j].s) {
					dist[loc[i].i][loc[j].i] = 1;
					dist[loc[j].i][loc[i].i] = 1;
				}
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (k == j || i == j)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int q = Integer.parseInt(br.readLine());
		int x, y;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;

			sb.append(dist[x][y] == INF ? "-1" : dist[x][y]).append("\n");
		}

		System.out.print(sb.toString());
	}
}