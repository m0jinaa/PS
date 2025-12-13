import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;

	static int n;
	static int[] A;
	static Node[] tree;
	static Node[] lazy;

	static class Node {
		int v, ind;

		public Node(int v, int ind) {
			super();
			this.v = v;
			this.ind = ind;
		}
	}

	static void propagation(int l, int r, int x) {
		if (lazy[x].ind == 0)
			return;

		if (tree[x].v > lazy[x].v) {
			tree[x].v = lazy[x].v;
			tree[x].ind = lazy[x].ind;
		}

		// 아래로 전파
		if (l != r) {
			if (lazy[2 * x].v > lazy[x].v) {
				lazy[2 * x].v = lazy[x].v;
				lazy[2 * x].ind = lazy[x].ind;
			}
			if (lazy[2 * x + 1].v > lazy[x].v) {
				lazy[2 * x + 1].v = lazy[x].v;
				lazy[2 * x + 1].ind = lazy[x].ind;
			}
		}

		lazy[x].v = INF;
		lazy[x].ind = 0;
	}

	static void update(int l, int r, int s, int e, int v, int ind, int x) {

		propagation(l, r, x);

		if (r < s || e < l)
			return;
		else if (s <= l && r <= e) {
			lazy[x].v = v;
			lazy[x].ind = ind;
			propagation(l, r, x);
		} else {
			int mid = (l + r) / 2;

			update(l, mid, s, e, v, ind, 2 * x);
			update(mid + 1, r, s, e, v, ind, 2 * x + 1);
		}

	}

	static Node get(int l, int r, int t, int x) {
		propagation(l, r, x);

		if (l == r) {
			return tree[x];
		} else {
			int mid = (l + r) / 2;

			if (t <= mid) {
				return get(l, mid, t, 2 * x);
			} else {
				return get(mid + 1, r, t, 2 * x + 1);
			}
		}
	}

	static void init(int l, int r, int x) {
		if (l == r) {
			tree[x].v = A[l];
		} else {
			int mid = (l + r) / 2;

			init(l, mid, 2 * x);
			init(mid + 1, r, 2 * x + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int N = (int) Math.pow(2, (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		tree = new Node[N];
		lazy = new Node[N];

		for (int i = 1; i < N; i++) {
			tree[i] = new Node(INF, 0);
			lazy[i] = new Node(INF, 0);
		}

		int v;

		A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			v = Integer.parseInt(st.nextToken());

			A[i] = v;
		}

		// 초기 설정
		init(1, n, 1);

		int l, r, x;

		int q = Integer.parseInt(br.readLine());

		for (int i = 1; i <= q; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			update(1, n, l, r, x, i, 1);
		}

		int[] sum = new int[q + 1];

		Node now;

		for (int i = 1; i <= n; i++) {
			now = get(1, n, i, 1);

			sum[now.ind]++;

			sb.append(now.v).append(" ");
		}

		sb.append("\n");

		for (int i = 1; i <= q; i++) {
			sum[i] += sum[i - 1];

			sb.append(sum[i]).append(" ");
		}

		sb.append("\n");

		System.out.print(sb.toString());
	}
}