import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] sum = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
		}

		long answer = Long.MIN_VALUE;

		for (int i = k; i <= n; i++) {
			answer = Math.max(answer, sum[i] - sum[i - k]);
		}

		System.out.println(answer);

	}
}