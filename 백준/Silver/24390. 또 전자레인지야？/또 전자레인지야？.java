import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;

	static int[][] v;

	static class Time {
		int t, cnt, activated;

		public Time(int t, int cnt, int activated) {
			super();
			this.t = t;
			this.cnt = cnt;
			this.activated = activated;
		}

	}

	static int bfs() {
		LinkedList<Time> q = new LinkedList<>();

		q.add(new Time(0, 0, 0));
		v[0][0] = 0;

		int answer = -1;

		Time now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.t == n && now.activated == 1) {
				answer = now.cnt;
				break;
			}
			// 10 minutes
			if (now.t + 600 <= n && v[now.activated][now.t + 600] == -1) {
				v[now.activated][now.t + 600] = now.cnt + 1;
				q.add(new Time(now.t + 600, now.cnt + 1, now.activated));
			}

			// 1 minutes
			if (now.t + 60 <= n && v[now.activated][now.t + 60] == -1) {
				v[now.activated][now.t + 60] = now.cnt + 1;
				q.add(new Time(now.t + 60, now.cnt + 1, now.activated));
			}

			// 10 seconds
			if (now.t + 10 <= n && v[now.activated][now.t + 10] == -1) {
				v[now.activated][now.t + 10] = now.cnt + 1;
				q.add(new Time(now.t + 10, now.cnt + 1, now.activated));
			}

			// start button
			if (now.activated == 0) {
				if (now.t == 0) {
					if (now.t + 30 <= n && v[1][now.t + 30] == -1) {
						v[1][now.t + 30] = now.cnt + 1;
						q.add(new Time(now.t + 30, now.cnt + 1, 1));
					}
				} else {
					if (v[1][now.t] == -1) {
						v[1][now.t] = now.cnt + 1;
						q.add(new Time(now.t, now.cnt + 1, 1));
					}
				}

			} else {
				if (now.t + 30 <= n && v[now.activated][now.t + 30] == -1) {
					v[now.activated][now.t + 30] = now.cnt + 1;
					q.add(new Time(now.t + 30, now.cnt + 1, now.activated));
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		n = m * 60 + s;

		v = new int[2][n + 1];

		Arrays.fill(v[0], -1);
		Arrays.fill(v[1], -1);

		bfs();

		System.out.println(v[1][n]);

	}
}