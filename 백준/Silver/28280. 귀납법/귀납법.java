import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static final int MAX = 8_000_000;
	static boolean[] v;
	static LinkedList<Integer> q;

	static boolean inRange(int x) {
		if (x < 0 || x > MAX)
			return false;
		return true;
	}

	static int bfs(int x) {

		q.clear();
		v[x] = true;
		q.add(x);

		int qsize;

		int now, next;

		int answer = -1;
		int cnt = 0;

		end: while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();
				if (now == 1) {
					answer = cnt;
					break end;
				}
				next = now + 1;

				if (inRange(next) && !v[next]) {
					v[next] = true;
					q.add(next);
				}

				if (now % 2 != 0)
					continue;

				next = now / 2;

				if (inRange(next) && !v[next]) {
					v[next] = true;
					q.add(next);
				}
			}
			cnt++;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		v = new boolean[MAX + 1];
		q = new LinkedList<>();

		int n;

		int ret;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			Arrays.fill(v, false);

			ret = bfs(n);
			sb.append(ret == -1 ? "Wrong proof!" : ret).append("\n");
		}

		System.out.print(sb.toString());
	}
}