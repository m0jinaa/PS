import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = new int[] { 1, -1 };
	static boolean[][][] v;
	static LinkedList<Duck> q;

	static class Duck {
		int ind, x, t;

		public Duck(int ind, int x, int t) {
			super();
			this.ind = ind;
			this.x = x;
			this.t = t;
		}
	}

	static boolean inRange(int x) {
		if (x <= 0 || x > n)
			return false;
		return true;
	}

	static int bfs(int x, int y) {

		q.add(new Duck(0, x, 0));
		q.add(new Duck(1, y, 0));

		v[0][x][0] = true;
		v[1][y][0] = true;

		int answer = -1;
		Duck p;
		int nx;

		while (!q.isEmpty()) {
			p = q.poll();

			if (v[p.ind][p.x][p.t] && v[1 - p.ind][p.x][p.t]) {
				answer = p.t;
				break;
			}
			for (int i = 0; i < 2; i++) {
				nx = (int) (p.x + dx[i] * Math.pow(2, p.t));

				if (!inRange(nx) || v[p.ind][nx][p.t + 1])
					continue;
				v[p.ind][nx][p.t + 1] = true;

				q.add(new Duck(p.ind, nx, p.t + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		v = new boolean[2][n + 1][20];

		q = new LinkedList<>();

		System.out.println(bfs(a, b));
	}
}