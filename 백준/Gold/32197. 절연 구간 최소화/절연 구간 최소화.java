import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, t, c;

		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}

		public Node(int x, int t, int c) {
			super();
			this.x = x;
			this.t = t;
			this.c = c;
		}

		@Override
		public int compareTo(Node node) {
			return this.c - node.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] connectedTo = new ArrayList[n + 1];

		int s, e, t;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			if (connectedTo[s] == null) {
				connectedTo[s] = new ArrayList<>();
			}
			if (connectedTo[e] == null) {
				connectedTo[e] = new ArrayList<>();
			}

			connectedTo[s].add(new Node(e, t));
			connectedTo[e].add(new Node(s, t));
		}

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>();

		int[][] v = new int[2][n + 1];

		Arrays.fill(v[0], INF);
		Arrays.fill(v[1], INF);

		v[0][a] = 0;
		v[1][a] = 0;

		q.add(new Node(a, 0, 0));
		q.add(new Node(a, 1, 0));

		int answer = INF;

		Node now;
		int nt, nc, nx;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == b) {
				answer = now.c;
				break;
			}

			if (v[now.t][now.x] < now.c)
				continue;

			for (Node next : connectedTo[now.x]) {
				nc = now.c;
				nt = next.t;
				nx = next.x;

				if (now.t != next.t)
					nc++;

				if (v[nt][nx] <= nc)
					continue;

				v[nt][nx] = nc;
				q.add(new Node(nx, nt, nc));
			}
		}

		System.out.println(answer);
	}
}