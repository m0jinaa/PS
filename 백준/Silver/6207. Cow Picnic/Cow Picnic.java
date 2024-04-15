import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static boolean[][] v;
	static LinkedList<Node> q;

	static class Node {
		int x, s;

		public Node(int x, int s) {
			super();
			this.x = x;
			this.s = s;
		}
	}

	static void bfs() {

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int nx : canGo[now.x]) {
				if (v[now.s][nx])
					continue;
				v[now.s][nx] = true;
				q.add(new Node(nx, now.s));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new boolean[k][n + 1];
		q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int s;

		for (int i = 0; i < k; i++) {
			s = Integer.parseInt(br.readLine());
			q.add(new Node(s, i));
			v[i][s] = true;
		}
		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
		}

		bfs();

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < k; j++) {
				if (!v[j][i])
					continue;
				else if (j == k - 1) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}