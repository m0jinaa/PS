import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, t;

		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
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

		LinkedList<Node> withPortal = new LinkedList<>();
		LinkedList<Node> withoutPortal = new LinkedList<>();

		withoutPortal.add(new Node(0, 0));
		time[0] = 0;

		Node now;

		int answer = -1;

		while (!withPortal.isEmpty() || !withoutPortal.isEmpty()) {
			if (!withPortal.isEmpty())
				now = withPortal.poll();
			else
				now = withoutPortal.poll();

			if (now.x == n - 1) {
				answer = now.t;
				break;
			} else if (time[now.x] < now.t)
				continue;

			// red
			// blue
			if (portal[now.x][0] != -1 && time[portal[now.x][1]] > time[now.x]) {
				time[portal[now.x][1]] = time[now.x];
				withPortal.add(new Node(portal[now.x][1], time[now.x]));
			}

			// blue
			// normal
			if (portal[now.x][0] != 0 && time[now.x + 1] > time[now.x] + 1) {
				time[now.x + 1] = time[now.x] + 1;
				withoutPortal.add(new Node(now.x + 1, time[now.x] + 1));
			}
		}

		System.out.println(answer);
	}
}