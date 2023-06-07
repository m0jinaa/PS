import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int FULL = (1 << 9) - 1;
	static final int EMPTY = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int x, cnt, qsize, now, answer, nx;

		boolean[] v = new boolean[FULL + 1];

		LinkedList<Integer> q = new LinkedList<>();

		while (tc-- > 0) {

			q.clear();
			Arrays.fill(v, false);

			x = 0;

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					if ("H".equals(st.nextToken())) {
						x += 1 << (i * 3 + j);
					}
				}
			}

			v[x] = true;

			q.add(x);

			cnt = 0;
			answer = -1;

			end: while (!q.isEmpty()) {
				qsize = q.size();

				while (qsize-- > 0) {
					now = q.poll();
					if (now == EMPTY || now == FULL) {
						answer = cnt;
						break end;
					}
					// 가로
					// 1
					nx = now ^ (1 << 0) ^ (1 << 1) ^ (1 << 2);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 2
					nx = now ^ (1 << 3) ^ (1 << 4) ^ (1 << 5);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 3
					nx = now ^ (1 << 6) ^ (1 << 7) ^ (1 << 8);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 세로
					// 1
					nx = now ^ (1 << 0) ^ (1 << 3) ^ (1 << 6);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 2
					nx = now ^ (1 << 1) ^ (1 << 4) ^ (1 << 7);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 3
					nx = now ^ (1 << 2) ^ (1 << 4) ^ (1 << 8);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}

					// 대각선
					// 1
					nx = now ^ (1 << 0) ^ (1 << 4) ^ (1 << 8);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
					// 2
					nx = now ^ (1 << 2) ^ (1 << 4) ^ (1 << 6);
					if (!v[nx]) {
						v[nx] = true;
						q.add(nx);
					}
				}
				cnt++;
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}