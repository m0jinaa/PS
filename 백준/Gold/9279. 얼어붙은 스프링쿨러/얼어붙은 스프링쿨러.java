import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX_N = 1000;
	static final int INF = 1_000_000_007;

	static class Pipe {
		int x, c;

		public Pipe(int x, int c) {
			super();
			this.x = x;
			this.c = c;
		}
	}

	static int n;
	static boolean[] visited;
	static int[][] connectedTo;

	static int getMin(int x) {
		visited[x] = true;

		boolean last = true;

		int cost = 0;

		for (int nx = 1; nx <= n; nx++) {
			if (connectedTo[x][nx] == 0 || visited[nx])
				continue;
			last = false;

			cost += Math.min(connectedTo[x][nx], getMin(nx));
		}

		return last ? INF : cost;
	}

	public static void init() {
		for (int i = 1; i <= n; i++) {
			Arrays.fill(connectedTo[i], 0);
		}
		Arrays.fill(visited, false);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int u, v, w, center;
		String input;

		connectedTo = new int[MAX_N + 1][MAX_N + 1];
		visited = new boolean[MAX_N + 1];

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			st = new StringTokenizer(input);

			n = Integer.parseInt(st.nextToken());
			center = Integer.parseInt(st.nextToken());

			init();

			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());

				connectedTo[u][v] = w;
				connectedTo[v][u] = w;
			}

			sb.append(getMin(center)).append("\n");
		}

		System.out.print(sb.toString());
	}
}