import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int n, s, d, k;
	static int[] dx;
	static boolean[] v;

	static boolean inRange(int x) {
		if (x <= 0 || x > n)
			return false;
		return true;
	}

	static int bfs() {
		if (v[s] || v[d])
			return -1;
		LinkedList<Integer> q = new LinkedList<>();

		q.add(s);
		int qsize;
		int x, nx;
		v[s] = true;
		int answer = -1;
		int t = 0;
		end: while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				x = q.poll();

				if (x == d) {
					answer = t;
					break end;
				}

				for (int i = 0; i < 2; i++) {
					nx = x + dx[i];
					if (!inRange(nx) || v[nx])
						continue;
					q.add(nx);
					v[nx] = true;
				}
			}
			t++;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dx = new int[] { f, -b };

		v = new boolean[n + 1];

		if (k != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x;

			while (k-- > 0) {
				x = Integer.parseInt(st.nextToken());
				v[x] = true;
			}
		}

		int answer = bfs();

		System.out.print(answer == -1 ? "BUG FOUND" : answer);
	}
}