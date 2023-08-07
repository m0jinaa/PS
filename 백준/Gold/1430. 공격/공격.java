import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int d;

	static class Loc {
		int x;
		int c;

		public Loc(int x, int d) {
			super();
			this.x = x;
			this.c = d;
		}

	}

	static boolean[] v;

	static String bfs() {
		LinkedList<Loc> q = new LinkedList<>();

		q.add(new Loc(0, 0));
		v[0] = true;
		double answer = 0;

		Loc now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : canGo[now.x]) {
				if (v[y])
					continue;
				v[y] = true;
				answer += d * 1.0 / (Math.pow(2, now.c));

				q.add(new Loc(y, now.c + 1));
			}
		}

		return String.format("%.2f\n", answer);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		d = Integer.parseInt(st.nextToken());

		int[][] locations = new int[n + 1][2];

		locations[0][0] = Integer.parseInt(st.nextToken());
		locations[0][1] = Integer.parseInt(st.nextToken());

		int x, y;

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			locations[i][0] = x;
			locations[i][1] = y;
		}

		r *= r;

		int dist;

		for (int i = 0; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				dist = (int) (Math.pow(locations[i][0] - locations[j][0], 2)
						+ Math.pow(locations[i][1] - locations[j][1], 2));
				if (dist <= r) {
					canGo[i].add(j);
					canGo[j].add(i);
				}

			}
		}

		System.out.println(bfs());
	}
}