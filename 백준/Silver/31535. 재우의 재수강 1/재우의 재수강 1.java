import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] P = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		P[0] = P[1];

		int left = 0, cross = 0, right = 0;

		int lane = 1;

		// d 위치까지 올라가기
		while (A[lane] < d) {
			left += (A[lane] - A[lane - 1]) * P[lane];
			lane++;
		}

		int answer = left + (d - A[lane - 1]) * P[lane] + w * P[lane];

		left += (A[lane] - A[lane - 1]) * P[lane];

		lane++;

		int sum;

		for (; lane <= n; lane++) {
			cross = P[lane] * w;
			right += (Math.min(A[lane - 1] - d, A[lane - 1] - A[lane - 2]) * P[lane - 1]);
			sum = left + cross + right;

			answer = Math.min(answer, sum);
			left += (A[lane] - A[lane - 1]) * P[lane];
		}

		System.out.println(answer);

	}
}