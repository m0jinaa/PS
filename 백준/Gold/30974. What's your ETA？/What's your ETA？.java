import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Node>[] canGo;
	static long[] v;
	static final long INF = 1_000_000_000_000_001L;
	static boolean[] isPrime;

	static void init() {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= 10000000; i++) {
			if (!isPrime[i])
				continue;
			if (i >= 4000)
				continue;
			for (int j = i * i; j <= 10000000; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		long t;

		public Node(int x, long t) {
			super();
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Node node) {
			if (this.t < node.t)
				return -1;
			else if (this.t > node.t)
				return 1;
			else
				return 0;
		}
	}

	static long getMin() {
		PriorityQueue<Node> q = new PriorityQueue<>();

		Arrays.fill(v, INF);
		q.add(new Node(1, 0));
		v[1] = 0;
		long answer = INF;

		Node now;
		long nt;
		while (!q.isEmpty()) {
			now = q.poll();

			if (v[now.x] < now.t)
				continue;

			if (now.x == n) {
				answer = now.t;
				break;
			}

			for (Node next : canGo[now.x]) {
				nt = now.t + next.t;

				if (v[next.x] <= nt)
					continue;
				v[next.x] = nt;
				q.add(new Node(next.x, nt));

			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		isPrime = new boolean[10000001];

		int[] code = new int[n + 1];
		v = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
			code[i] = Integer.parseInt(st.nextToken());
		}

		init();

		int u, v, w;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			if (!isPrime[code[u] + code[v]])
				continue;
			canGo[u].add(new Node(v, w));
			canGo[v].add(new Node(u, w));
		}

		long answer = getMin();

		System.out.println(answer == INF ? "Now where are you?" : answer);
	}
}