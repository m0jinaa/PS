import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] nextPage = new ArrayList[n + 1];

		int m, p;

		for (int i = 1; i <= n; i++) {
			nextPage[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());

			while (m-- > 0) {
				p = Integer.parseInt(st.nextToken());

				nextPage[i].add(p);
			}
		}

		int[] v = new int[n + 1];

		final int INF = 1_000_000_007;

		Arrays.fill(v, INF);

		v[1] = 1;

		int shortest = INF;

		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);

		boolean allPage = true;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			// 마지막 페이지 도달
			if (nextPage[now].isEmpty()) {
				shortest = Math.min(shortest, v[now]);
			} else {
				for (int next : nextPage[now]) {
					if (v[next] != INF)// cycle
						continue;
					v[next] = v[now] + 1;
					q.add(next);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (v[i] != INF)
				continue;
			allPage = false;
			break;
		}

		sb.append(allPage ? "Y\n" : "N\n");
		sb.append(shortest).append("\n");

		System.out.println(sb.toString());
	}
}