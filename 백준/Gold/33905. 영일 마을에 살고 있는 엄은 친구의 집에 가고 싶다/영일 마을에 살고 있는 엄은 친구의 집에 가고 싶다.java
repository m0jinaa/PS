import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] canGo = new LinkedList[n + 2];

		for (int i = 1; i <= n + 1; i++) {
			canGo[i] = new LinkedList<>();
		}

		int u, v;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
			canGo[v].add(u);
		}

		boolean[] unavailable = new boolean[n + 2];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (k-- > 0) {
			x = Integer.parseInt(st.nextToken());
			unavailable[x] = true;
		}

		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);
		unavailable[1] = true;

		int answer = 0;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int nx : canGo[x]) {
				if (unavailable[nx])
					continue;
				unavailable[nx] = true;
				q.add(nx);
				answer++;
			}
		}

		System.out.println(answer);
	}
}