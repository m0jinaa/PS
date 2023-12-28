import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_000;

	static class SegTree {
		long[] tree;

		public SegTree(int n) {
			int size = (int) Math.pow(2, (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

			tree = new long[size];
		}

		void update(int l, int r, int x, long v, int k) {
			if (r < x || x < l)
				return;
			else if (l == r) {
				tree[k] += v;
			} else {
				int m = (l + r) / 2;
				update(l, m, x, v, 2 * k);
				update(m + 1, r, x, v, 2 * k + 1);

				tree[k] = tree[2 * k] + tree[2 * k + 1];
			}
		}

		long get(int l, int r, int s, int e, int k) {
			if (r < s || e < l)
				return 0;
			else if (s <= l && r <= e)
				return tree[k];
			else {
				int m = (l + r) / 2;
				return get(l, m, s, e, 2 * k) + get(m + 1, r, s, e, 2 * k + 1);
			}
		}
	}

	static class Dot implements Comparable<Dot> {
		int x, y;
		long c;

		public Dot(int x) {
			this.x = x;
			this.y = 0;
			this.c = 0;
		}

		@Override
		public int compareTo(Dot d) {
			if (this.x != d.x) {
				return this.x - d.x;
			} else {
				return d.y - this.y;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		SegTree tree = new SegTree(MAX + 1);

		Dot[] dots = new Dot[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dots[i] = new Dot(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dots[i].y = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dots);

		for (int i = 0; i < n; i++) {
			dots[i].c = tree.get(0, MAX, 0, dots[i].y - 1, 1);
			tree.update(0, MAX, dots[i].y, 1, 1);
		}

		long ans = 0;

		SegTree cntTree = new SegTree(MAX + 1);

		for (int i = 0; i < n; i++) {
			ans += cntTree.get(0, MAX, 0, dots[i].y - 1, 1);
			cntTree.update(0, MAX, dots[i].y, dots[i].c, 1);
		}

		System.out.println(ans);
	}
}