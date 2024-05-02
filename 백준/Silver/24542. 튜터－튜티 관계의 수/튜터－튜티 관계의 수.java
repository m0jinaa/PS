import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] cnt;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x < y) {
			cnt[x] += cnt[y];
			cnt[y] = 0;
			parent[y] = x;
		} else {
			cnt[y] += cnt[x];
			cnt[x] = 0;
			parent[x] = y;
		}
	}

	static void init(int size) {
		parent = new int[size + 1];
		cnt = new int[size + 1];

		for (int i = 1; i <= size; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		init(n);

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		long answer = 1;

		final int MOD = 1_000_000_007;

		for (int i = 1; i <= n; i++) {
			if (find(i) != i)
				continue;

			answer = (answer * cnt[i]) % MOD;
		}

		System.out.println(answer);
	}
}