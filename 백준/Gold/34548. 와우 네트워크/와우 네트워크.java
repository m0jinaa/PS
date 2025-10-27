import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] group;

	static class Connection implements Comparable<Connection> {
		int a, b, t;

		public Connection(int a, int b, int t) {
			super();
			this.a = a;
			this.b = b;
			this.t = t;
		};

		@Override
		public int compareTo(Connection c) {
			return this.t - c.t;
		}
	}

	static int find(int x) {
		if (group[x] != x) {
			group[x] = find(group[x]);
		}

		return group[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else if (x < y) {
			group[y] = x;
		} else {
			group[x] = y;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		group = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			group[i] = i;
		}

		Connection[] connections = new Connection[m];

		int a, b, c;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			connections[i] = new Connection(a, b, c);
		}

		Arrays.sort(connections);

		int bef = 1;

		int g = n;

		long score = 0;

		for (Connection conn : connections) {

			score += 1L * (conn.t - bef) * g;

			if (union(conn.a, conn.b)) {
				g--;
			}

			bef = conn.t;
		}

		score += 1L * (t + 1 - bef) * g;

		System.out.println(score);
	}
}