import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] depth;
	static ArrayList<Integer>[] canGo;

	static void dfs(int x) {
		for (int y : canGo[x]) {
			if (depth[y] != -1)
				continue;
			depth[y] = depth[x] + 1;
			dfs(y);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int u, v;

		canGo = new ArrayList[n + 1];
		depth = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			depth[i] = -1;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
			canGo[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(canGo[i]);
		}

		depth[r] = 0;

		dfs(r);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append(depth[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}