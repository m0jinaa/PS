import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static class Bus {
		int ind;
		long sx, sy, ex, ey;

		public Bus(int ind, long sx, long sy, long ex, long ey) {
			super();
			this.ind = ind;
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}

		public boolean contains(long x, long y) {
			if (this.sx <= x && x <= this.ex && this.sy <= y && y <= this.ey)
				return true;
			return false;
		}

		public boolean cross(Bus b2) {
			int d1 = ccw(this.sx, this.sy, this.ex, this.ey, b2.sx, b2.sy);
			int d2 = ccw(this.sx, this.sy, this.ex, this.ey, b2.ex, b2.ey);
			int d3 = ccw(b2.sx, b2.sy, b2.ex, b2.ey, this.sx, this.sy);
			int d4 = ccw(b2.sx, b2.sy, b2.ex, b2.ey, this.ex, this.ey);

			int v1 = d1 * d2;
			int v2 = d3 * d4;

			if (v1 == 0 && v2 == 0) {
				if (d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0) {
					long a, b, c, d;
					if (this.sx == this.ex) {
						a = Math.min(this.sy, this.ey);
						b = Math.max(this.sy, this.ey);
					} else {
						a = Math.min(this.sx, this.ex);
						b = Math.max(this.sx, this.ex);

					}
					if (b2.sx == b2.ex) {
						c = Math.min(b2.sy, b2.ey);
						d = Math.max(b2.sy, b2.ey);
					} else {
						c = Math.min(b2.sx, b2.ex);
						d = Math.max(b2.sx, b2.ex);
					}

					return c <= b && a <= d;

				}
				return true;
			} else if (v1 <= 0 && v2 <= 0)
				return true;
			else
				return false;
		}

		private int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
			long v = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
			if (v > 0)
				return 1;
			else if (v < 0)
				return -1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		Bus[] buses = new Bus[k + 1];
		int ind;
		long sx, sy, ex, ey;
		long temp;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			ind = Integer.parseInt(st.nextToken());
			sx = Long.parseLong(st.nextToken());
			sy = Long.parseLong(st.nextToken());
			ex = Long.parseLong(st.nextToken());
			ey = Long.parseLong(st.nextToken());

			if (sx > ex) {
				temp = sx;
				sx = ex;
				ex = temp;
			}

			if (sy > ey) {
				temp = sy;
				sy = ey;
				ey = temp;
			}

			buses[ind] = new Bus(ind, sx, sy, ex, ey);
		}

		st = new StringTokenizer(br.readLine(), " ");

		sx = Long.parseLong(st.nextToken());
		sy = Long.parseLong(st.nextToken());
		ex = Long.parseLong(st.nextToken());
		ey = Long.parseLong(st.nextToken());

		int[] visited = new int[k + 1];

		Arrays.fill(visited, -1);

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 1; i <= k; i++) {

			if (buses[i].contains(sx, sy)) {
				q.add(buses[i].ind);
				visited[buses[i].ind] = 1;
			}
		}

		int answer = -1;
		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			if (buses[now].contains(ex, ey)) {
				answer = visited[now];
				break;
			}

			for (int i = 1; i <= k; i++) {
				if (visited[i] != -1)
					continue;
				if (buses[now].cross(buses[i])) {
					visited[i] = visited[now] + 1;
					q.add(i);
				}
			}
		}

		System.out.println(answer);

	}
}