import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] loc;
	static int[] tree;
	static int n;

	static int getLeft(int x) {
		int s = 0;
		int e = n - 1;

		int m;
		int ret = -1;

		while (s <= e) {
			m = (s + e) / 2;

			if (loc[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	static int getRight(int x) {
		int s = 0;
		int e = n - 1;

		int m;
		int ret = -1;

		while (s <= e) {
			m = (s + e) / 2;

			if (loc[m] <= x) {
				ret = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ret;
	}

	static int get(int s, int e, int l, int r, int k) {
		if (r < s || e < l)
			return 0;
		else if (l <= s && e <= r)
			return tree[k];
		else {
			int m = (s + e) / 2;

			int ret = Math.max(get(s, m, l, r, 2 * k), get(m + 1, e, l, r, 2 * k + 1));

			return ret;
		}
	}

	static void update(int s, int e, int ind, int v, int k) {
		if (ind < s || e < ind)
			return;
		tree[k] = Math.max(tree[k], v);

		if (s != e) {
			int m = (s + e) / 2;

			update(s, m, ind, v, 2 * k);
			update(m + 1, e, ind, v, 2 * k + 1);
		}
	}

	static class Cow implements Comparable<Cow> {
		int x, h;

		public Cow(int x, int h) {
			super();
			this.x = x;
			this.h = h;
		}

		@Override
		public int compareTo(Cow c) {
			return c.h - this.h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		int d = Integer.parseInt(st.nextToken());

		Cow[] cows = new Cow[n];
		loc = new int[n];

		int N = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		tree = new int[N];

		int x, h;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			loc[i] = x;

			cows[i] = new Cow(x, h);
		}

		Arrays.sort(cows);
		Arrays.sort(loc);

		int answer = 0;
		int left, right;
		int l, m, r;
		for (Cow c : cows) {

			l = getLeft(c.x - d);
			m = getLeft(c.x);
			r = getRight(c.x + d);

			left = get(0, n - 1, l, m, 1);
			right = get(0, n - 1, m, r, 1);

			if (left >= 2 * c.h && right >= 2 * c.h) {
				answer++;
			}

			update(0, n - 1, m, c.h, 1);
		}

		System.out.println(answer);
	}
}