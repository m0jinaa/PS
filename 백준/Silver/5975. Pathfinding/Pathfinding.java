import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		int[][] canGo = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				canGo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] v = new int[n + 1];

		v[start] = 1;

		LinkedList<Integer> q = new LinkedList<>();

		q.add(start);

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int next = 1; next <= n; next++) {
				if (canGo[now][next] == 0 || v[next] != 0)
					continue;
				v[next] = v[now] + 1;
				q.add(next);
			}
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (cnt == n)
				break;
			for (int j = 1; j <= n; j++) {
				if (v[j] != i)
					continue;
				sb.append(j).append(" ");
				cnt++;
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}