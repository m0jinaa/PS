import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		final int INF = 1_000_000_007;

		LinkedList<Node>[] canGo = new LinkedList[n + 1];
		int[] cost = new int[n];
		int[] dist = new int[n];

		for (int i = 0; i < n; i++) {
			canGo[i] = new LinkedList<>();
			cost[i] = INF;
			dist[i] = INF;
		}

		int s, e, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			canGo[s].add(new Node(e, c));
		}

		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);
		cost[0] = 0;
		dist[0] = 0;

		int x;

		int answer = -1;

		while (!q.isEmpty()) {
			x = q.poll();

			if (x == 1) {
				answer = cost[x];
				break;
			}
			for (Node next : canGo[x]) {
				if (dist[next.x] < dist[x] + 1)
					continue;

				dist[next.x] = dist[x] + 1;
				cost[next.x] = Math.min(cost[next.x], cost[x] + next.c);
				q.add(next.x);
			}
		}

		System.out.println(answer);
	}
}