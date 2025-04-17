import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] sumTree;

	static void update(int s, int e, int ind, int v, int x) {
		if (ind < s || ind > e)
			return;
		else {
			sumTree[x] += v;

			if (s != e) {
				int m = (s + e) / 2;

				update(s, m, ind, v, 2 * x);
				update(m + 1, e, ind, v, 2 * x + 1);
			}
		}
	}

	static int get(int s, int e, int l, int r, int x) {
		if (r < s || e < l)
			return 0;
		else if (l <= s && e <= r) {
			return sumTree[x];
		} else {
			int m = (s + e) / 2;

			return get(s, m, l, r, 2 * x) + get(m + 1, e, l, r, 2 * x + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		boolean[] blocked = new boolean[n + 1];

		int N = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

		sumTree = new int[N];

		for (int i = 1; i <= n; i++) {
			update(1, n, i, 1, 1);
		}

		String order;
		int a, b;
		int s;
		// 막히지 않은 도로의 개수
		int unblocked = n;
		int shouldbe;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			order = st.nextToken();

			switch (order) {
			case "?":
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				shouldbe = Math.abs(a - b) + 1;

				if (blocked[a] || blocked[b]) {
					sb.append("impossible\n");
				} else {
					if (a < b) {
						s = get(1, n, a, b, 1);
					} else {
						s = get(1, n, b, a, 1);
					}

					// 양방향중 어느 한곳이라도 이어져 있다면 가능
					if (s == shouldbe || n - shouldbe == unblocked - s) {
						sb.append("possible\n");
					} else {
						sb.append("impossible\n");
					}
				}
				break;
			case "-":
				a = Integer.parseInt(st.nextToken());
				update(1, n, a, -1, 1);
				blocked[a] = true;
				unblocked--;
				break;
			case "+":
				a = Integer.parseInt(st.nextToken());
				update(1, n, a, 1, 1);
				blocked[a] = false;
				unblocked++;
				break;
			}
		}

		System.out.print(sb.toString());
	}
}