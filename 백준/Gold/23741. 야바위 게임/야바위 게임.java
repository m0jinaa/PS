import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] v;
	static ArrayList<Integer>[] canSwitch;
	static boolean[] possible;

	static class Node {
		int x, c;

		public Node(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	static int bfs(int x, int c) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, 0));
		int answer = 0;
		v[x][0] = true;
		Node now;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.c == c) {
				possible[now.x] = true;
				answer++;
				continue;
			}

			for (int y : canSwitch[now.x]) {
				if (v[y][now.c + 1])
					continue;
				v[y][now.c + 1] = true;
				q.add(new Node(y, now.c + 1));
			}
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int a, b;
		canSwitch = new ArrayList[n + 1];
		possible = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			canSwitch[i] = new ArrayList<>();
		}

		v = new boolean[n + 1][y + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canSwitch[a].add(b);
			canSwitch[b].add(a);
		}

		int count = bfs(x, y);

		if (count == 0) {
			sb.append(-1);
		} else {
			for (int i = 1; i <= n; i++) {
				if (!possible[i])
					continue;
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}