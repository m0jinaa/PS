import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] sumTree;

	static int update(int l, int r, int ind, int x) {
		if (r < ind || ind < l)
			return sumTree[x];
		else if (l == r) {
			return sumTree[x] += 1;
		} else {
			int m = (l + r) / 2;

			return sumTree[x] = update(l, m, ind, 2 * x) + update(m + 1, r, ind, 2 * x + 1);
		}
	}

	static int get(int l, int r, int s, int e, int x) {
		if (r < s || e < l)
			return 0;
		else if (s <= l && r <= e) {
			return sumTree[x];
		} else {
			int m = (l + r) / 2;

			return get(l, m, s, e, 2 * x) + get(m + 1, r, s, e, 2 * x + 1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int n, N;
		int x;
		long cnt;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			N = (int) Math.pow(2, (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

			sumTree = new int[N];

			st = new StringTokenizer(br.readLine(), " ");

			cnt = 0;

			for (int i = 1; i <= n; i++) {
				x = Integer.parseInt(st.nextToken());
				update(1, n, x, 1);
				cnt += get(1, n, x + 1, n, 1);
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}