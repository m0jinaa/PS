import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;
	static LinkedList<Integer> q;
	static ArrayList<Integer>[] canGo;

	static int bfs(int x) {
		int cnt = 1;
		q.add(x);
		v[x] = true;
		int now;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int y : canGo[now]) {
				if (v[y])
					continue;
				v[y] = true;
				cnt++;
				q.add(y);
			}
		}

		return cnt;
	}

	static class Cow {
		int ind;
		int x, y, r;

		public Cow(int ind, int x, int y, int r) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
			this.r = r;
		}

		public void reach(Cow b) {
			int dist = (int) (Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));

			if (dist <= this.r * this.r) {
				canGo[this.ind].add(b.ind);
			}

			if (dist <= b.r * b.r) {
				canGo[b.ind].add(this.ind);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Cow[] cows = new Cow[n];
		canGo = new ArrayList[n];
		q = new LinkedList<>();

		int x, y, r;
		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			cows[i] = new Cow(i, x, y, r);
			for (int j = 0; j < i; j++) {
				cows[i].reach(cows[j]);
			}
		}

		v = new boolean[n];
		int answer = 0;
		int ret;
		for (int i = 0; i < n; i++) {
			Arrays.fill(v, false);
			ret = bfs(i);
			answer = Math.max(answer, ret);
		}

		System.out.println(answer);
	}
}