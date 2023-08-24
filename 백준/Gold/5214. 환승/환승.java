import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] line;
	static ArrayList<Integer>[] station;
	static boolean[] vLine, vStation;

	static class Node {
		int l, x, c;

		public Node(int l, int x, int c) {
			super();
			this.l = l;
			this.x = x;
			this.c = c;
		}
	}

	static int bfs() {
		int answer = -1;

		LinkedList<Node> q = new LinkedList<>();
		for (int l : station[1]) {

			q.add(new Node(l, 1, 1));
		}

		vStation[1] = true;
		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == n) {
				answer = now.c;
				break;
			}

			for (int l : station[now.x]) {
				if (vLine[l])
					continue;
				vLine[l] = true;
				for (int x : line[l]) {
					if (vStation[x])
						continue;
					vStation[x] = true;
					q.add(new Node(l, x, now.c + 1));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		line = new int[m + 1][k];
		vLine = new boolean[m + 1];

		station = new ArrayList[n + 1];
		vStation = new boolean[n + 1];

		int x;

		for (int i = 1; i <= n; i++) {
			station[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < k; j++) {
				x = Integer.parseInt(st.nextToken());
				line[i][j] = x;

				station[x].add(i);
			}
		}

		System.out.println(bfs());
	}
}