import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Elevator {
		int x, start, interval, time;

		public Elevator(int x, int start, int interval, int time) {
			super();
			this.x = x;
			this.start = start;
			this.interval = interval;
			this.time = time;
		}
	}

	static class Floor implements Comparable<Floor> {
		int x, t;

		public Floor(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Floor f) {
			return this.t - f.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Elevator>[] canGo = new LinkedList[n + 1];
		int[] visited = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			visited[i] = INF;
			canGo[i] = new LinkedList<>();
		}
		int s, e;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			canGo[s].add(new Elevator(e, 0, (e - s) * 2, e - s));
			canGo[e].add(new Elevator(s, e - s, (e - s) * 2, e - s));
		}

		PriorityQueue<Floor> q = new PriorityQueue<>();

		q.add(new Floor(1, 0));
		visited[1] = 0;

		Floor f;

		int answer = -1;
		int nt;

		while (!q.isEmpty()) {
			f = q.poll();

			if (visited[f.x] != f.t)
				continue;
			else if (f.x == n) {
				answer = f.t;
				break;
			}

			for (Elevator elev : canGo[f.x]) {
				nt = elev.interval * (int) Math.ceil(Math.max(elev.start, f.t) * 1.0 / elev.interval) + elev.time;

				if (visited[elev.x] <= nt)
					continue;
				visited[elev.x] = nt;
				q.add(new Floor(elev.x, nt));
			}
		}

        // 초 단위로 변환
		answer *= 5;

		System.out.println(answer);
	}
}