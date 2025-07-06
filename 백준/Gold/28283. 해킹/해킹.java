import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] canGo = new LinkedList[n + 1];
		long[] dist = new long[n + 1];
		LinkedList<Integer> q = new LinkedList<>();

		long[] earn = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			earn[i] = Long.parseLong(st.nextToken());
			dist[i] = INF;
			canGo[i] = new LinkedList<>();
		}

		int s, e;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			canGo[s].add(e);
			canGo[e].add(s);
		}

		st = new StringTokenizer(br.readLine(), " ");

		while (y-- > 0) {
			s = Integer.parseInt(st.nextToken());

			q.add(s);
			dist[s] = 0;
		}

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int nx : canGo[now]) {
				if (dist[nx] != INF)
					continue;
				dist[nx] = dist[now] + 1;
				q.add(nx);
			}
		}

		long answer = -1;

		boolean infinite = false;

		long[] howMuch = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			if (dist[i] == INF && earn[i] != 0) {
				infinite = true;
				break;
			}
			howMuch[i] = dist[i] * earn[i];
		}

		if (!infinite) {

			Arrays.sort(howMuch);

			answer = 0;

			for (int i = 0; i < x; i++) {
				answer += howMuch[n - i];
			}
		}

		System.out.println(answer);
	}
}