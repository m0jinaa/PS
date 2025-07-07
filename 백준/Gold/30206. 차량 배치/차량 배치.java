import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;
		final int MOD = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] canGo = new LinkedList[n + 1];
		int[] cnt = new int[n + 1];
		int[] time = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new LinkedList<>();
			time[i] = INF;
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

        // 1번 노드에서 각 노드까지 걸리는 시간 체크
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		time[1] = 0;
		cnt[0]++;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int y : canGo[x]) {
				if (time[y] != INF)
					continue;
				time[y] = time[x] + 1;

				cnt[time[y]]++;
				q.add(y);
			}
		}

		long answer = 1L;

		for (int i = 0; i <= n; i++) {
			answer = (answer * (cnt[i] + 1)) % MOD;
		}

		// 차량배치를 아예 안하는 경우를 제외
		answer -= 1;

		System.out.println(answer);
	}
}