import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final long INF = Long.MAX_VALUE;

	static ArrayList<Node>[] connectedTo;

	static class Node implements Comparable<Node> {
		int x;
		long d;

		public Node(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}

		@Override
		public int compareTo(Node node) {
			return (this.d < node.d) ? -1 : (this.d > node.d) ? 1 : 0;
		}
	}

	static long[] time;
	static PriorityQueue<Node> q;

	static void getTime(int s) {
		Arrays.fill(time, INF);
		q.clear();

		q.add(new Node(s, 0));

		time[s] = 0;

		Node now;

		long nt;

		while (!q.isEmpty()) {
			now = q.poll();

			if (time[now.x] < now.d)
				continue;

			for (Node next : connectedTo[now.x]) {
				nt = now.d + next.d;

				if (time[next.x] > nt) {
					time[next.x] = nt;
					q.add(new Node(next.x, nt));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		connectedTo = new ArrayList[n + 1];
		time = new long[n + 1];
		q = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		int u, v;
		long c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());

			connectedTo[u].add(new Node(v, c));
			connectedTo[v].add(new Node(u, c));
		}

		st = new StringTokenizer(br.readLine(), " ");

		long[] elevator = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			elevator[i] = Long.parseLong(st.nextToken());
		}

		getTime(1);
		long[] firstFloor = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			firstFloor[i] = time[i];
		}

		getTime(n);

		long[] lastFloor = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			lastFloor[i] = time[i];
		}

		long answer = INF;

		for (int i = 1; i <= n; i++) {
			if (firstFloor[i] == INF || lastFloor[i] == INF || elevator[i] == -1)
				continue;

			answer = Math.min(answer, firstFloor[i] + lastFloor[i] + (k - 1) * elevator[i]);
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}