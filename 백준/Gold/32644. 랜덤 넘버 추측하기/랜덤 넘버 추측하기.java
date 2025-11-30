import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static long[] sumTree;

	static void update(int l, int r, int x, long v, int t) {
		if (x < l || r < x)
			return;
		sumTree[t] += v;

		if (l != r) {
			int mid = (l + r) / 2;

			update(l, mid, x, v, 2 * t);
			update(mid + 1, r, x, v, 2 * t + 1);
		}
	}

	static long get(int l, int r, int x, int t) {
		if (x < l)
			return 0L;
		else if (r <= x)
			return sumTree[t];
		else {
			int mid = (l + r) / 2;

			return get(l, mid, x, 2 * t) + get(mid + 1, r, x, 2 * t + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int N = (int) Math.pow(2, (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		sumTree = new long[N];

		p = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			update(1, n, i, p[i], 1);
		}

		int k;

		st = new StringTokenizer(br.readLine(), " ");

		long bef;

		while (m-- > 0) {
			k = Integer.parseInt(st.nextToken());

			bef = get(1, n, k - 1, 1);
			update(1, n, k, -p[k], 1);

			sb.append(bef + 1).append(" ");
		}

		System.out.println(sb.toString());
	}
}