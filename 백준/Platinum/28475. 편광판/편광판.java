import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] state;
	static int[] tree;
	static int n;

	static int get(int s, int e, int l, int r, int k) {
		if (r < s || e < l)
			return 1;
		else if (l <= s && e <= r)
			return tree[k];
		else {
			int m = (s + e) / 2;

			int ret = get(s, m, l, r, 2 * k) & get(m + 1, e, l, r, 2 * k + 1);

			return ret;
		}
	}

	static int update(int s, int e, int ind, int v, int k) {
		if (ind < s || e < ind)
			return tree[k];
		if (s != e) {
			int m = (s + e) / 2;

			return tree[k] = update(s, m, ind, v, 2 * k) & update(m + 1, e, ind, v, 2 * k + 1);
		} else {
			return tree[k] = v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int N = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		tree = new int[N];
		state = new int[n + 1];

		Arrays.fill(state, -3);

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			state[i] = x % 4;

			if (i > 1) {
				if (Math.abs(state[i - 1] - state[i]) == 2)
					update(1, n, i - 1, 0, 1);
				else
					update(1, n, i - 1, 1, 1);
			}

			if (i < n) {
				if (Math.abs(state[i + 1] - state[i]) == 2)
					update(1, n, i, 0, 1);
				else
					update(1, n, i, 1, 1);
			}
		}

		int q, a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			q = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			switch (q) {
			case 1:
				state[a] = b % 4;

				if (a > 1) {
					if (Math.abs(state[a - 1] - state[a]) == 2)
						update(1, n, a - 1, 0, 1);
					else
						update(1, n, a - 1, 1, 1);
				}

				if (a < n) {
					if (Math.abs(state[a + 1] - state[a]) == 2)
						update(1, n, a, 0, 1);
					else
						update(1, n, a, 1, 1);
				}
				break;
			case 2:
				sb.append(get(1, n, a, b - 1, 1)).append("\n");
			}
		}

		System.out.print(sb.toString());

	}
}