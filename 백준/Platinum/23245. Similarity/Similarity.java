import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_001;

	static class PTree {
		long[] tree;

		public PTree() {
			tree = new long[MAX + 1];
		}

		void update(int x, long v) {
			while (x <= MAX) {
				tree[x] += v;
				x += (x & (-x));
			}
		}

		long get(int x) {
			long v = 0;

			while (x > 0) {
				v += tree[x];
				x -= (x & (-x));
			}

			return v;
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

		PTree tree = new PTree();

		Dot[] dots = new Dot[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dots[i] = new Dot(Integer.parseInt(st.nextToken() + 1));
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			dots[i].y = Integer.parseInt(st.nextToken()) + 1;
		}

		Arrays.sort(dots);

		for (int i = 0; i < n; i++) {
			dots[i].c = tree.get(dots[i].y - 1);
			tree.update(dots[i].y, 1);
		}

		long ans = 0;

		PTree cntTree = new PTree();

		for (int i = 0; i < n; i++) {
			ans += cntTree.get(dots[i].y - 1);
			cntTree.update(dots[i].y, dots[i].c);
		}

		System.out.println(ans);
	}
}