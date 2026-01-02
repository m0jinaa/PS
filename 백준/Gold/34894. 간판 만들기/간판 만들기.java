import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final long INF = Long.MAX_VALUE;

		int n = Integer.parseInt(br.readLine());

		char[] S = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine(), " ");

		long[] A = new long[n];

		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		long[] cost = new long[5];

		Arrays.fill(cost, INF);

		for (int i = 0; i < n; i++) {
			switch (S[i]) {
			case 'U':
				cost[0] = Math.min(cost[0], A[i]);
				break;
			case 'O':
				if (cost[0] != INF) {
					cost[1] = Math.min(cost[1], cost[0] + A[i]);
				}
				break;

			case 'S':
				if (cost[1] != INF) {
					cost[2] = Math.min(cost[2], cost[1] + A[i]);
				}
				break;

			case 'P':
				if (cost[2] != INF) {
					cost[3] = Math.min(cost[3], cost[2] + A[i]);
				}
				break;

			case 'C':
				if (cost[3] != INF) {
					cost[4] = Math.min(cost[4], cost[3] + A[i]);
				}
				break;
			}
		}

		long answer = cost[4] == INF ? -1 : cost[4];

		System.out.println(answer);
	}
}