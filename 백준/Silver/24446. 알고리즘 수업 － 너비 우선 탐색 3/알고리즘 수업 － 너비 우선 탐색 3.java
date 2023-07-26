import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] canGo;
	static int[] depth;

	static void bfs(int x) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(x);
		depth[x] = 0;

		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : canGo[now]) {
				if (depth[y] != -1)
					continue;
				depth[y] = depth[now] + 1;
				q.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		depth = new int[n + 1];

		Arrays.fill(depth, -1);

		canGo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int u, v;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
			canGo[v].add(u);
		}

		bfs(r);

		for (int i = 1; i <= n; i++) {
			sb.append(depth[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}