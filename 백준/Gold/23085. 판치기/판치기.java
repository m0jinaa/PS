import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] v;
	static int n, k;
	static LinkedList<Coin> q;

	static class Coin {
		int h, t, c;

		public Coin(int h, int t, int c) {
			super();
			this.h = h;
			this.t = t;
			this.c = c;
		}

	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x > n || y < 0 || y > n)
			return false;
		return true;
	}

	static int bfs() {
		Coin now;
		int answer = -1;
		int nh, nt;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.t == n) {
				answer = now.c;
				break;
			}

			for (int i = 0; i <= k; i++) {
				if (i > now.h || k - i > now.t)
					continue;
				nh = now.h + k - 2 * i;
				nt = now.t + 2 * i - k;

				if (!inRange(nh, nt) || v[nh][nt])
					continue;
				v[nh][nt] = true;
				q.add(new Coin(nh, nt, now.c + 1));
			}
		}

		q.clear();

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		v = new boolean[n + 1][n + 1];
		q = new LinkedList<>();

		char[] row = br.readLine().toCharArray();

		int h = 0, t = 0;

		for (char c : row) {
			if (c == 'H')
				h++;
			else
				t++;
		}

		v[h][t] = true;
		q.add(new Coin(h, t, 0));

		System.out.println(bfs());
	}
}