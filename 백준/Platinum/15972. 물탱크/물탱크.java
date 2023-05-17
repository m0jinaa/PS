import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;

	static class Loc implements Comparable<Loc> {
		int x, y, h;

		public Loc(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public int compareTo(Loc o) {
			return this.h - o.h;
		}
	}

	public static boolean inRange(int a, int b) {
		if (a < 0 || a >= n || b < 0 || b >= m)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		int h = Integer.parseInt(st.nextToken());

		boolean[][] v = new boolean[n][m];

		int[][] ud = new int[n + 1][m];

		int[][] lr = new int[n][m + 1];

		for (int i = 0; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				ud[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j <= m; j++) {
				lr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Loc> pq = new PriorityQueue<>();

		// 위아래줄 살펴보고 뚤린 곳 있으면 pq에 넣기 (구멍이 연결된 공간,높이)
		for (int i = 0; i < m; i++) {
			if (ud[0][i] != -1) {
				pq.add(new Loc(0, i, ud[0][i]));
			}
			if (ud[n][i] != -1) {
				pq.add(new Loc(n - 1, i, ud[n][i]));
			}
		}

		// 왼쪽오른쪽 살펴보고 뚤린 곳 있으면 pq에 넣기 (구멍이 연결된 공간,높이)
		for (int i = 0; i < n; i++) {
			if (lr[i][0] != -1) {
				pq.add(new Loc(i, 0, lr[i][0]));
			}
			if (lr[i][m] != -1) {
				pq.add(new Loc(i, m - 1, lr[i][m]));
			}
		}

		int answer = 0;

		int vCnt = 0;
		Loc now;
		int nh;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (v[now.x][now.y])
				continue;
			v[now.x][now.y] = true;
			answer += now.h;
			vCnt++;
			// 위아래 살펴보기
			if (inRange(now.x - 1, now.y) && ud[now.x][now.y] != -1 && !v[now.x - 1][now.y]) {
				nh = Math.max(now.h, ud[now.x][now.y]);
				pq.add(new Loc(now.x - 1, now.y, nh));

			}
			if (inRange(now.x + 1, now.y) && ud[now.x + 1][now.y] != -1 && !v[now.x + 1][now.y]) {
				nh = Math.max(now.h, ud[now.x + 1][now.y]);
				pq.add(new Loc(now.x + 1, now.y, nh));

			}
			if (inRange(now.x, now.y - 1) && lr[now.x][now.y] != -1 && !v[now.x][now.y - 1]) {
				nh = Math.max(now.h, lr[now.x][now.y]);
				pq.add(new Loc(now.x, now.y - 1, nh));

			}
			if (inRange(now.x, now.y + 1) && lr[now.x][now.y + 1] != -1 && !v[now.x][now.y + 1]) {
				nh = Math.max(now.h, lr[now.x][now.y + 1]);
				pq.add(new Loc(now.x, now.y + 1, nh));

			}

		}

		answer += (n * m - vCnt) * h;

		System.out.println(answer);
	}

}