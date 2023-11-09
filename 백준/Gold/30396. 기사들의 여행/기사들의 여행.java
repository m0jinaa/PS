import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n = 4, m = 16;
	static int target;

	static int[] dx = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dy = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	static int bfs(int start) {

		LinkedList<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[1 << m];

		q.add(start);
		v[start] = true;

		int t = 0;
		int qsize, now, next;

		int answer = -1;
		int x, y, nx, ny, np;

		end: while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();

				if (target == now) {
					answer = t;
					break end;
				}

				for (int i = 0, p = 1; i < m; i++, p <<= 1) {
					if ((now & p) == 0)
						continue;

					x = i / n;
					y = i % n;

					for (int j = 0; j < 8; j++) {
						nx = x + dx[j];
						ny = y + dy[j];

						if (!inRange(nx, ny)) // 격자 벗어남
							continue;

						np = 1 << (nx * n + ny);

						if ((now & np) != 0)// 이미 나이트 존재
							continue;

						next = (now ^ p) | np;

						if (v[next])
							continue;
						v[next] = true;
						q.add(next);
					}
				}
			}
			t++;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int start = 0;
		target = 0;

		int x = 1;
		char[] row;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (row[j] == '1')
					start += x;
				x <<= 1;
			}
		}

		x = 1;
		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (row[j] == '1')
					target += x;
				x <<= 1;
			}
		}

		System.out.println(bfs(start));
	}
}