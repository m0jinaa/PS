import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] cow;

	static class Wormhole implements Comparable<Wormhole> {
		int x, y, d;

		public Wormhole(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Wormhole w) {
			return w.d - this.d;
		}

	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		else if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n];
		cow = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			cow[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		ArrayList<Wormhole> wormholes = new ArrayList<>();

		int x, y, d;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());

			wormholes.add(new Wormhole(x, y, d));
		}

		Collections.sort(wormholes);

		int ind = 0;
		int answer = -1;

		for (Wormhole w : wormholes) {
			while (ind < n && find(ind) == find(cow[ind])) {
				ind++;
			}

			if (ind == n)
				break;

			if (union(w.x, w.y)) {
				answer = w.d;
			}
		}

		System.out.println(answer);
	}
}