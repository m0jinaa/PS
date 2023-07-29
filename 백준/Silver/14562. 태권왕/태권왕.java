import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Score> q;

	static class Score {
		int s, t, cnt;

		public Score(int s, int t, int cnt) {
			super();
			this.s = s;
			this.t = t;
			this.cnt = cnt;
		}
	}

	static int bfs(int x, int y) {

		q.clear();

		q.add(new Score(x, y, 0));

		Score now;
		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.s == now.t) {
				answer = now.cnt;
				break;
			} else if (now.s > now.t) {
				continue;
			} else {
				q.add(new Score(now.s * 2, now.t + 3, now.cnt + 1));
				q.add(new Score(now.s + 1, now.t, now.cnt + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		q = new LinkedList<Score>();

		int c = Integer.parseInt(br.readLine());
		int s, t;

		while (c-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			sb.append(bfs(s, t)).append("\n");
		}

		System.out.print(sb.toString());
	}
}