import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int INF;

	static class Node {
		int x, v, c;

		public Node(int x, int v, int c) {
			super();
			this.x = x;
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		INF = 1 << n;
		int[][] time = new int[n][n];

		int[][] cost = new int[n][INF];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(cost[i], 20000);
			for (int j = 0; j < n; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 20000;

		cost[k][0] = 0;

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(k, 1 << k, 0));

		Node now;
		int nv, nc;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.v == INF - 1) {
				answer = Math.min(answer, now.c);
				continue;

			}

			for (int i = 0; i < n; i++) {
				if (now.x == i)
					continue;

				nv = now.v | (1 << i);
				nc = now.c + time[now.x][i];

				if (cost[i][nv] > nc) {
					cost[i][nv] = nc;
					q.add(new Node(i, nv, nc));
				}
			}
		}
		System.out.println(answer);

	}
}