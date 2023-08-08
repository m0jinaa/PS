import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static HashSet<Cube> v;
	static LinkedList<Cube> q;
	static int[][] dc;

	static class Cube {
		int[] cubes;
		int d;

		public Cube(int[] cubes, int d) {
			super();
			this.cubes = cubes;
			this.d = d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(cubes);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cube other = (Cube) obj;
			if (!Arrays.equals(cubes, other.cubes))
				return false;
			return true;
		}

		public boolean same() {
			int x = this.cubes[0];

			for (int i = 0; i < n; i++) {
				if (cubes[i] != x)
					return false;
			}
			return true;
		}
	}

	static int bfs() {
		int answer = -1;

		Cube now;
		int[] next;
		Cube ncube;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.same()) {
				answer = now.d;
				break;
			}

			for (int i = 0; i < m; i++) {
				next = new int[n];
				for (int j = 0; j < n; j++) {
					next[j] = (now.cubes[j] + dc[i][j]) % 5;
				}

				ncube = new Cube(next, now.d + 1);
				if (v.contains(ncube))
					continue;
				v.add(ncube);
				q.add(ncube);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] status = new int[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}

		int c, x;

		dc = new int[m][n];
		q = new LinkedList<>();
		v = new HashSet<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken()) - 1;
				dc[i][x] = i + 1;
			}
		}

		q.add(new Cube(status, 0));
		v.add(new Cube(status, 0));
		System.out.println(bfs());
	}
}