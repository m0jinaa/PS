import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, t;

		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Node node) {
			return this.t - node.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] portal = new int[n][2];

		for (int i = 0; i < n; i++) {
			Arrays.fill(portal[i], -1);
		}

		int t, a, b;

		while (c-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			portal[a][0] = t;
			portal[a][1] = b;
		}

		final int INF = 1_000_000_007;

		int[] time = new int[n];

		Arrays.fill(time, INF);

		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(0, 0));
		time[0] = 0;

		Node now;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == n - 1) {
				answer = now.t;
				break;
			} else if (time[now.x] < now.t)
				continue;

			// red
			// blue
			if (portal[now.x][0] != -1 && time[portal[now.x][1]] > time[now.x]) {
				time[portal[now.x][1]] = time[now.x];
				q.add(new Node(portal[now.x][1], time[now.x]));
			}

			// blue
			// normal
			if (portal[now.x][0] != 0 && time[now.x + 1] > time[now.x] + 1) {
				time[now.x + 1] = time[now.x] + 1;
				q.add(new Node(now.x + 1, time[now.x] + 1));
			}
		}

		System.out.println(answer);
	}
}