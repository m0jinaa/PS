import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, w;

		public Node(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Node node) {
			return this.w - node.w;
		}
	}

	static final int INF = 1_000_000_007;
	static int[] dist;
	static PriorityQueue<Node> q;
	static ArrayList<Node>[] connectedTo;

	static int getDist(int s, int e) {

		Arrays.fill(dist, INF);

		q.clear();

		q.add(new Node(s, 0));
		dist[s] = 0;

		Node now;

		int answer = INF;
		int nw, nx;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == e) {
				answer = now.w;
				break;
			}
			if (dist[now.x] != now.w)
				continue;

			for (Node next : connectedTo[now.x]) {
				nx = next.x;
				nw = now.w + next.w;

				if (dist[nx] <= nw)
					continue;

				dist[nx] = nw;
				q.add(new Node(nx, nw));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		connectedTo = new ArrayList[V + 1];
		dist = new int[V + 1];
		q = new PriorityQueue<>();

		for (int i = 1; i <= V; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		int u, v, w;

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			connectedTo[u].add(new Node(v, w));
			connectedTo[v].add(new Node(u, w));
		}

		st = new StringTokenizer(br.readLine(), " ");

		int[] sellingPoint = new int[10];

		for (int i = 0; i < 10; i++) {
			sellingPoint[i] = Integer.parseInt(st.nextToken());
		}

		int start = Integer.parseInt(br.readLine());

		int[] myDist = new int[V + 1];

		getDist(start, 0);

		for (int i = 1; i <= V; i++) {
			myDist[i] = dist[i];
		}

		int s = sellingPoint[0];

		long d = 0L;
		int ret;

		int answer = INF;

		for (int e : sellingPoint) {
			ret = getDist(s, e);

			if (ret == INF)
				continue;

			d += ret;

			if (d >= myDist[e] && answer > e) {
				answer = e;
			}
			s = e;
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}