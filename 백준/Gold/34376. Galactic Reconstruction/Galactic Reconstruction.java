import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] wealth;
	static int[] parent;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	// return 값 -1 : 비용 부족, 0 : 이미 결합되어있음, 1: 결합 성공
	static int union(int x, int y, long c) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return 0;
		} else if (wealth[x] < c || wealth[y] < c) {
			return -1;
		} else if (x < y) {
			wealth[x] = wealth[x] + wealth[y] - 2 * c;
			wealth[y] = 0;
			parent[y] = x;
		} else {
			wealth[y] = wealth[x] + wealth[y] - 2 * c;
			wealth[x] = 0;
			parent[x] = y;
		}

		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		wealth = new long[n + 1];
		parent = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			wealth[i] = Long.parseLong(st.nextToken());
		}

		int a, b;
		long c;

		int ret;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());

			ret = union(a, b, c);

			if (ret == 0) {
				sb.append("UNNECESSARY\n");
			} else if (ret == 1) {
				sb.append("BUILT\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}

		System.out.print(sb.toString());
	}
}