import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;

	static class Road implements Comparable<Road> {
		int x, y, w;

		public Road(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Road r) {
			return r.w - this.w;
		}
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		else if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		parent = new int[c + 1];

		for (int i = 1; i <= c; i++) {
			parent[i] = i;
		}

		int x, y, w;

		Road[] roads = new Road[r];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			roads[i] = new Road(x, y, w);
		}

		Arrays.sort(roads);

		LinkedList<Integer> q = new LinkedList<>();

		while (d-- > 0) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int answer = -1;
		int a, qsize;
		for (Road road : roads) {
			if (q.isEmpty())
				break;
			union(road.x, road.y);

			answer = road.w;

			qsize = q.size();

			while (qsize-- > 0) {
				a = q.poll();
				if (find(a) != 1) {
					q.add(a);
				}
			}
		}

		System.out.print(answer);
	}
}