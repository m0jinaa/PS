import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static long[] dist;

	static ArrayList<Node>[] canGo;

	static class Node {
		int x;
		long d;

		public Node(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}
	}

	static long bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);
		Arrays.fill(dist, -1);

		dist[1] = 0;
		int x;
		long answer = 0;
		while (!q.isEmpty()) {
			x = q.poll();
			answer = Math.max(answer, dist[x]);

			for (Node next : canGo[x]) {
				if (dist[next.x] != -1)
					continue;
				dist[next.x] = dist[x] + next.d;
				q.add(next.x);
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int a, b;
		long c;

		canGo = new ArrayList[n + 1];
		dist = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			canGo[a].add(new Node(b, c));
			canGo[b].add(new Node(a, c));
		}

		System.out.println(bfs());
	}
}