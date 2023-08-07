import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int x;
		boolean r;

		public Loc(int x, boolean r) {
			super();
			this.x = x;
			this.r = r;
		}

	}

	static boolean[] visited, leaf;
	static ArrayList<Integer>[] canGo;
	static LinkedList<Loc> q;

	static boolean bfs() {
		boolean possible = false;
		Loc now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (leaf[now.x] && now.r) {
				possible = true;
				break;
			}

			for (int y : canGo[now.x]) {
				if (visited[y])
					continue;
				visited[y] = true;

				q.add(new Loc(y, now.r));

			}
		}
		return possible;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		canGo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		leaf = new boolean[n + 1];
		visited = new boolean[n + 1];
		int u, v;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
			canGo[v].add(u);

		}

		for (int i = 1; i <= n; i++) {
			if (canGo[i].size() == 1) {
				leaf[i] = true;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		q.add(new Loc(b, false));
		q.add(new Loc(c, false));
		q.add(new Loc(a, true));

		visited[a] = true;
		visited[b] = true;
		visited[c] = true;

		System.out.println(bfs() ? "YES" : "NO");

	}
}