import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, cnt;

	static int find(int x) {
		if (x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		else if (x < y) {
			cnt[x] += cnt[y];
			parent[y] = x;
		} else {
			cnt[y] += cnt[x];
			parent[x] = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		cnt = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}

		int answer = 0;

		int u, v;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			union(u, v);

			if (cnt[1] == n) {
				answer = i;
				break;
			}
		}

		System.out.println(cnt[1] != n ? -1 : answer);
	}
}