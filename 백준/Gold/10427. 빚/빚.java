import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final long INF = Long.MAX_VALUE;

		int t = Integer.parseInt(br.readLine());

		int n;
		long[] A, sum;
		long min;
		long answer;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			A = new long[n + 1];
			sum = new long[n + 1];

			for (int i = 1; i <= n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);

			for (int i = 1; i <= n; i++) {
				sum[i] = sum[i - 1] + A[i];
			}

			answer = 0;

			for (int i = 1; i < n; i++) {
				min = INF;
				for (int j = i + 1; j <= n; j++) {
					min = Math.min(min, (i + 1) * A[j] - (sum[j] - sum[j - (i + 1)]));
				}
				answer += min;

			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}