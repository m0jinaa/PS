import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static boolean[] vLine, vStation;
	static ArrayList<Integer>[] station, line;
	static PriorityQueue<Node> q;

	static class Node implements Comparable<Node> {
		int x, l, c;

		public Node(int x, int l, int c) {
			super();
			this.x = x;
			this.l = l;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}

	static int bfs(int start, int end) {
		vStation[start] = true;

		for (int s : station[start]) {
			q.add(new Node(start, s, 0));
			vLine[s] = true;
		}

		int answer = -1;

		Node now;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == end) {
				answer = now.c;
				break;
			}

			for (int ns : line[now.l]) {
				if (vStation[ns])
					continue;

				vStation[ns] = true;
				q.add(new Node(ns, now.l, now.c));

				for (int nl : station[ns]) {
					if (vLine[nl])
						continue;
					vLine[nl] = true;
					q.add(new Node(ns, nl, now.c + 1));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		vLine = new boolean[L + 1];
		vStation = new boolean[N + 1];

		station = new ArrayList[N + 1];
		line = new ArrayList[N + 1];

		int x;

		for (int i = 1; i <= N; i++) {
			station[i] = new ArrayList<>();
		}

		for (int i = 1; i <= L; i++) {
			line[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			while (true) {
				x = Integer.parseInt(st.nextToken());
				if (x == -1)
					break;

				station[x].add(i);
				line[i].add(x);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		q = new PriorityQueue<>();

		System.out.println(bfs(start, end));
	}
}