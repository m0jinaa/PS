import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n, m;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static LinkedList<Node> q;
	static boolean[][][] v;
	static int[][] map;

	static class Node {
		int x, y, p;

		public Node(int x, int y, int p) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
		}

	}

	static boolean inRange(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > m)
			return false;
		return true;
	}

	static boolean bfs(int sx, int sy, int ex, int ey, int p) {
		q.clear();

		int nx, ny, np, d;

		v[sx][sy][p] = true;

		Node now;

		q.add(new Node(sx, sy, p));
		boolean answer = false;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == ex && now.y == ey) {
				answer = true;
				break;
			} else if (now.p == 0)
				continue;

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if (!inRange(nx, ny))
					continue;

				d = map[nx][ny] - map[now.x][now.y];

				np = now.p - 1;

				if (d > now.p || v[nx][ny][np])
					continue;

				v[nx][ny][np] = true;
				q.add(new Node(nx, ny, np));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		q = new LinkedList<>();

		int t = Integer.parseInt(br.readLine());

		int o, f, sx, sy, ex, ey;

		int x, y, h;

		while (t-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			o = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());

			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			map = new int[n + 1][m + 1];

			v = new boolean[n + 1][m + 1][f + 1];

			while (o-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				h = Integer.parseInt(st.nextToken());

				map[x][y] = h;
			}
			sb.append(bfs(sx, sy, ex, ey, f) ? "잘했어!!\n" : "인성 문제있어??\n");
		}

		System.out.print(sb.toString());
	}
}