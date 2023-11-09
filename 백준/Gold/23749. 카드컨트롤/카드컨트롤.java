import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] v;

	static int bfs(int x) {
		int answer = -1;

		LinkedList<Integer> q = new LinkedList<>();

		q.add(x);
		v[x] = true;

		int t = 0;
		int qsize = 0;

		int now;
		int next;
		end: while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();

				if (check(now)) {
					answer = t;
					break end;
				}

				for (int i = 1; i < n; i++) {
					next = 0;

					for (int j = 0, y = 1; j < n; j++, y <<= 1) {
						if (j < i) {
							next |= ((now & y) << 1);
						} else if (j == i) {
							if ((now & y) == 0)
								continue;
							next |= 1;
						} else {
							next |= (now & y);
						}
					}

					if (v[next])
						continue;

					v[next] = true;
					q.add(next);
				}
			}
			t++;
		}

		return answer;
	}

	static boolean check(int x) {
		int junseok = 0;
		int suhyeon = 0;

		for (int i = 0; i < n; i++) {
			if ((x & (1 << i)) == 0)
				continue;
			if (i % 2 == 0) {
				junseok++;
			} else {
				suhyeon++;
			}
		}

		return junseok > suhyeon;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()) * 2;

		v = new boolean[1 << n];

		int now = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			if ("X".equals(st.nextToken()))
				continue;
			now |= (1 << i);
		}

		int answer = bfs(now);

		System.out.println(answer);
	}
}