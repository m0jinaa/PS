import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static long[] lazy;

	static long update(int l, int r, int s, int e, long v, int k) {
		propagation(l, r, k);
		if (r < s || e < l) {
			return tree[k];
		} else if (s <= l && r <= e) {
			lazy[k] += v;
			propagation(l, r, k);
			return tree[k];
		} else {
			int m = (l + r) / 2;
			return tree[k] = update(l, m, s, e, v, 2 * k) + update(m + 1, r, s, e, v, 2 * k + 1);
		}
	}

	static String get(int l, int r, long v, int k) {
		propagation(l, r, k);
		if (tree[k] < v) {// 넘치는 경우
			return "OVERFLOW";
		} else if (l == r) {
			return String.format("%.02f\n",l-1+(Math.round(1.0*100*v/tree[k])/100.0));
		} else {
			int m = (l + r) / 2;
			propagation(l, m, 2*k);
			propagation(m+1, r, 2*k+1);
			if (tree[2 * k] >= v) {
				return get(l, m, v, 2 * k);
			} else {
				return get(m + 1, r, v - tree[2 * k], 2 * k + 1);
			}
		}
	}

	static void propagation(int l, int r, int k) {
		if (lazy[k] == 0)
			return;
		tree[k] += (r - l + 1) * lazy[k];
		if (l != r) {
			lazy[2 * k] += lazy[k];
			lazy[2 * k + 1] += lazy[k];
		}
		lazy[k] = 0;
	}

	static final int LEN =1040000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int b, h, w, d;

		int N = (int) Math.pow(2, (int) Math.ceil(Math.log10(LEN + 1) / Math.log10(2)) + 1);

		tree = new long[N];
		lazy = new long[N];

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			b = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			update(1, LEN, b + 1, b + h, w * d, 1);
			
		}
		int volume = Integer.parseInt(br.readLine());
		
		System.out.print(get(1, LEN, volume, 1));
	}
}
